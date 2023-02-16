package com.alibou.security.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User implements UserDetails
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false, unique=true)
  private String email;

  @Column(nullable=false)
  private String password;
  @Column(nullable = false, length = 300)
  private String firstName;

  @Column(nullable = false, length = 300)
  private String lastName;

  @Column(nullable = false, length = 300)
  private String address;

  @Column(nullable = false, length = 2)
  private String enabled;

  @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
  @JoinTable(
          name="users_roles",
          joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
          inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
  private List<Role> roles = new ArrayList<>();

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
    return mapRoles;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
