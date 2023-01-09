package com.ragbecca.boekenwinkel.entities.vm;

import com.ragbecca.boekenwinkel.entities.Address;
import com.ragbecca.boekenwinkel.entities.PhoneNumber;
import com.ragbecca.boekenwinkel.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVM {

    private String username;

    private String displayName;

    private String role;

    private PhoneNumber phoneNumber;
    private Address address;

    public UserVM(User user) {
        this.setUsername(user.getUsername());
        this.setDisplayName(user.getDisplayName());
        this.setRole(user.getRole());
        this.setPhoneNumber(user.getPhoneNumber());
        this.setAddress(user.getAddress());
    }
}
