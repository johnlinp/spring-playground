package io.github.johnlinp.springplayground;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(classes = TestSecurityContext.class),
        @ContextConfiguration(classes = UserInfoServiceTest.Config.class)
})
public class UserInfoServiceTest
{
    @Configuration
    public static class Config
    {
        @Bean
        public UserInfoService userInfoService ()
        {
            return new UserInfoServiceImpl();
        }
    }

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void testGetUserInfoWithoutUser ()
    {
        assertThatThrownBy(() -> userInfoService.getUserInfo())
                .isInstanceOf(AuthenticationCredentialsNotFoundException.class);
    }

    @Test
    @WithMockUser
    public void testGetUserInfoWithUser ()
    {
        String userInfo = userInfoService.getUserInfo();
        assertThat(userInfo).isEqualTo("info about user");
    }
}
