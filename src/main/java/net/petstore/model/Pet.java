package net.petstore.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Pet
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-05-06T17:38:50.285Z")
@Data
public class Pet   {

  public Pet(){
    super();
  }

  @JsonProperty("id")
  private Long id = null;


  @JsonProperty("category")
  private Category category = null;


  @NotNull
  @JsonProperty("name")
  private String name = null;

  @NotNull
  @JsonProperty("photoUrls")
  @Valid
  private List<String> photoUrls = new ArrayList<String>();


  @JsonProperty("tags")
  @Valid
  private List<Tag> tags = null;



  @JsonProperty("status")
  private PetStatusEnum status = null;


}

