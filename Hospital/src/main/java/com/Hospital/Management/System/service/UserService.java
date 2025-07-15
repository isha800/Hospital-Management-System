package com.Hospital.Management.System.service;
import com.Hospital.Management.System.dto.UpdateProfileRequest;
import com.Hospital.Management.System.dto.UserResponse;
import com.Hospital.Management.System.entity.User;
import com.Hospital.Management.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired private UserRepository userRepository;

    public UserResponse getProfile(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserResponse(user);
    }

    public UserResponse updateProfile(String email, UpdateProfileRequest request) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setGender(request.getGender());
        user.setAddress(request.getAddress());

        return new UserResponse(userRepository.save(user));
    }
}
