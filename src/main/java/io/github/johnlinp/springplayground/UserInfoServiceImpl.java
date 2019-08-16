package io.github.johnlinp.springplayground;

import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService
{
    @Override
    public String getUserInfo ()
    {
        return "info about user";
    }
}
