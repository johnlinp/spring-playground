package io.github.johnlinp.springplayground;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class UserInfoServiceImplTest
{
    private UserInfoServiceImpl userInfoService;

    @Before
    public void setUp ()
    {
        userInfoService = new UserInfoServiceImpl();
    }

    @Test
    public void testGetUserInfo ()
    {
        String userInfo = userInfoService.getUserInfo();
        assertThat(userInfo).isEqualTo("info about user");
    }
}
