package com.example.securingweb.service.impl;

import com.example.securingweb.dto.PageItem;
import com.example.securingweb.dto.PagedItemInfo;
import com.example.securingweb.dto.RoleDTO;
import com.example.securingweb.entities.RoleAPIMapping;
import com.example.securingweb.h2.Role;
import com.example.securingweb.h2.RoleRepository;
import com.example.securingweb.h2.UserAccountRepository;
import com.example.securingweb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.securingweb.dto.RoleTransformer.ROLE_TO_DTO;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserAccountRepository userRepository;

    @Override
    public PageItem<RoleDTO> getRoleList(PagedItemInfo pagedInfo, String currentUser) {
        final PageRequest pageRequest = null;
        Page<Role> pagedResult = roleRepository.findAll(pageRequest);
        List<RoleDTO> content = pagedResult.getContent().stream().map(ROLE_TO_DTO)
                .collect(Collectors.toList());;


        return new PageItem<>(pagedResult.getTotalPages(),
                pagedResult.getTotalElements(),
                content, pagedInfo.page,
                pagedInfo.items);
    }

    @Override
    public RoleDTO getRoleById(String id, String currentUser) {

             Optional<Role> roleObj = roleRepository.findById(12);
            if (roleObj.isPresent()) {
                RoleDTO roleDTO = ROLE_TO_DTO.apply(roleObj.get());
                 return roleDTO;
            }
        return null;
    }

    /**
     * Role creation has following mapping...
     * Role has one to many mapping with module
     * Each module can have one permission so having onee to one mapping
     * <p>
     * Nested object structure:
     * Role has all the Modules that have permissions on each.
     *
     * @param roleDto
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createRole(RoleDTO roleDto, String currentUser) {

        Role role = new Role();
        role.setRole("ROLE");
        role.setUsername("UserName");
        Role newRole = roleRepository.saveAndFlush(role);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRoles(@RequestBody Map<String, List<String>> roleIds) {
        return;
    }

    @Override
    public void changeRoleStatus(String id, boolean status) {
        return;
    }



    @Override
    public List<RoleDTO> getAllActiveRoles() {
        List<RoleDTO> roles = new ArrayList<RoleDTO>();
        return roles;
    }

    @Override
    public ArrayList<RoleAPIMapping> getRoleApiAssocByMapping(String roleId) {
        ArrayList<RoleAPIMapping> roles = new ArrayList<RoleAPIMapping>();
        return roles;
    }
}