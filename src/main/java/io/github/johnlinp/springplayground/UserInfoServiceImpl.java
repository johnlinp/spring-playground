package io.github.johnlinp.springplayground;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService
{
    @Override
    public String getUserInfo ()
    {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return "info about " + authentication.getName();
    }
}
