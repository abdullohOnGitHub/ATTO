package uz.najot.atto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T>{
    Boolean success;
    Integer code;
    String message;
    T data;
}
