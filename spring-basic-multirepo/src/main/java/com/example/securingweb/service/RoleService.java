package com.example.securingweb.service;

import com.example.securingweb.dto.PageItem;
import com.example.securingweb.dto.PagedItemInfo;
import com.example.securingweb.dto.RoleDTO;
import com.example.securingweb.entities.RoleAPIMapping;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 @Service
 public interface RoleService {
        PageItem<RoleDTO> getRoleList(PagedItemInfo pagedInfo, String currentUser);
        RoleDTO getRoleById(String id, String currentUser);
        void createRole(RoleDTO roleDto, String currentUser);
        void deleteRoles(Map<String, List<String>> roleIds);
        void changeRoleStatus(String id, boolean status);

        List<RoleDTO> getAllActiveRoles();

        ArrayList<RoleAPIMapping> getRoleApiAssocByMapping(String roleId);
}
