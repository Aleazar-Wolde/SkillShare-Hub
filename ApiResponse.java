// src/main/java/com/yourname/skillsharehub/payload/ApiResponse.java
package com.yourname.skillsharehub.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {

    private Boolean success;
    private String message;
}
