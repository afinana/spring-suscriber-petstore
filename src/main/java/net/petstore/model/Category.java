package net.petstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Category
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-05-06T17:38:50.285Z")
@Data
public class Category   {

  public Category(){
    super();
  }

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;


}

