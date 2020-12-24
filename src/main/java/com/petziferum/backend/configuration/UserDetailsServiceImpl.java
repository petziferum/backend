package com.petziferum.backend.configuration;


import com.petziferum.backend.model.ERole;
import com.petziferum.backend.model.Role;
import com.petziferum.backend.model.User;
import com.petziferum.backend.repository.RoleRepository;
import com.petziferum.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;



	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}


	public void updateUserDataAsAdmin(User _existingUser, User _updatedUser) {

		if (_updatedUser.getUsername() != null) {
			_existingUser.setUsername(_updatedUser.getUsername());
		}
		;
		if (_updatedUser.getEmail() != null) {
			_existingUser.setEmail(_updatedUser.getEmail());
		}
		;
		if (_updatedUser.getFirstName() != null) {
			_existingUser.setFirstName(_updatedUser.getFirstName());
		}
		;
		if (_updatedUser.getLastName() != null) {
			_existingUser.setLastName(_updatedUser.getLastName());
		}
		;
		if (_updatedUser.getUserDepartment() != null) {
			_existingUser.setUserDepartment(_updatedUser.getUserDepartment());
		}
		;
		if (_updatedUser.getUserOffice() != null) {
			_existingUser.setUserOffice(_updatedUser.getUserOffice());
		}
		;
		if (_updatedUser.getUserImage() != null) {
			_existingUser.setUserImage(_updatedUser.getUserImage());
		}
		;
		if (_updatedUser.getPassword() != null) {
			_existingUser.setPassword(encoder.encode(_updatedUser.getPassword()));
		}

		if (_updatedUser.getJoinedProjects() != null) {
			_existingUser.setJoinedProjects(_updatedUser.getJoinedProjects());
		}

		if (_updatedUser.getOwnProjects() != null) {
			_existingUser.setOwnProjects(_updatedUser.getOwnProjects());
		}

		if (_updatedUser.isDarkMode() == true) {
			_existingUser.setDarkMode(true);
		} else {
			_existingUser.setDarkMode(false);
		}

		userRepository.save(_existingUser);
	}





	public void updateUser(User _existingUser, User _updatedUser) {

		if (_updatedUser.getUsername() != null) {
			_existingUser.setUsername(_updatedUser.getUsername());
		}
		;
		if (_updatedUser.getEmail() != null) {
			_existingUser.setEmail(_updatedUser.getEmail());
		}
		;
		if (_updatedUser.getFirstName() != null) {
			_existingUser.setFirstName(_updatedUser.getFirstName());
		}
		;
		if (_updatedUser.getLastName() != null) {
			_existingUser.setLastName(_updatedUser.getLastName());
		}
		;
		if (_updatedUser.getUserDepartment() != null) {
			_existingUser.setUserDepartment(_updatedUser.getUserDepartment());
		}
		;
		if (_updatedUser.getUserOffice() != null) {
			_existingUser.setUserOffice(_updatedUser.getUserOffice());
		}
		;
		if (_updatedUser.getUserImage() != null) {
			_existingUser.setUserImage(_updatedUser.getUserImage());
		}
		;
		if (_updatedUser.getPassword() != null) {
			_existingUser.setPassword(encoder.encode(_updatedUser.getPassword()));
		}

		if (_updatedUser.isDarkMode() == true) {
			_existingUser.setDarkMode(true);
		} else {
			_existingUser.setDarkMode(false);
		}

/*		if (_updatedUser.getJoinedProjects() != null) {
			_existingUser.setJoinedProjects(_updatedUser.getJoinedProjects());
		}

		if (_updatedUser.getOwnProjects() != null) {
			_existingUser.setOwnProjects(_updatedUser.getOwnProjects());
		}*/

		userRepository.save(_existingUser);
	}






	public void newUserRoles(User _newadminuser, Set<String> strRoles) {

		Set<Role> _newRoles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			_newRoles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {


					case "admin":
						Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						_newRoles.add(adminRole);

						break;

					case "nwk":
						Role nwkRole = roleRepository.findByName(ERole.ROLE_NWK)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						_newRoles.add(nwkRole);

						break;

/*					case "mod":
						Role modRole = roleRepository.findByName(ERole.ROLE_MOD)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						_newRoles.add(modRole);

						break;*/

					default:
						System.out.println("Nichts eingegeben");
				}
			});
		}
		Role userRole = roleRepository.findByName(ERole.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		_newRoles.add(userRole);

		_newadminuser.setRoles(_newRoles);
		userRepository.save(_newadminuser);

	}
}




