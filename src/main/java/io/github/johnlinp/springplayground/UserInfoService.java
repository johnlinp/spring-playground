package io.github.johnlinp.springplayground;

import org.springframework.security.access.prepost.PreAuthorize;

public interface UserInfoService
{
    @PreAuthorize("isAuthenticated()")
    String getUserInfo ();
}
