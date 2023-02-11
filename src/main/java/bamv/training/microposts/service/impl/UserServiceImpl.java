package bamv.training.microposts.service.impl;

import bamv.training.microposts.security.SecurityUserDetailsImpl;
import bamv.training.microposts.dto.UserDto;
import bamv.training.microposts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public UserDto selectUser(String userId) {
        RowMapper<UserDto> rowMapper = new BeanPropertyRowMapper<UserDto>(UserDto.class);
        String query = "SELECT * FROM m_user WHERE user_id = ?";
        UserDto user = jdbcTemplate.queryForObject(query, rowMapper, userId);
        return user;
    }

    @Override
    public UserDetails selectUserForLogin(String userId) {
        RowMapper<SecurityUserDetailsImpl> rowMapper = new BeanPropertyRowMapper<SecurityUserDetailsImpl>(SecurityUserDetailsImpl.class);
        String query = "SELECT user_id, password FROM m_user WHERE user_id = ?";
        SecurityUserDetailsImpl user = jdbcTemplate.queryForObject(query, rowMapper, userId);
        return user;
    }
}
