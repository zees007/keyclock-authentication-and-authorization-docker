package com.devzees.keyclock.configs;

/**
 * Author: Zeeshan Adil
 * User:mhmdz
 * Date:30-08-2024
 * Time:01:11
 */

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        // Extract roles from the 'realm_access' claim
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");
        List<String> roles = (List<String>) realmAccess.get("roles");

        // Map roles to Spring Security authorities
        return roles != null ?
                roles.stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                        .collect(Collectors.toList())
                :
                new ArrayList<>();
    }
}