package com.tavant.practicalassissmentrestapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data


public class ResourceNotFoundException extends Exception{
	    
       public ResourceNotFoundException(String msg){
    	    super(msg);   
       }
}
