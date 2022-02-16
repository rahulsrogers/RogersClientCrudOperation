package com.chat.features.model;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.function.Predicate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Entity

@ApiModel(description = "details about the models")
@Table
public class RogersClientModel {

  //  @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @PrimaryKey
    private String  guid;
    @Min(1)
    @Max(100)
   private String title ;
    @Min(1)
    @Max(100)
    private String description;
   private Brand brand;
   private String launchDate;
    private int launchYear;
   private LaunchQuarter launchQuarter ;
   @Min(1)
   @Max(20)
   private String productOwner ;
   @Min(1)
   @Max(2000)
   private String  businessValue ;
   @Min(1)
   @Max(100)
    private String expectedRoi ;
    private   Boolean is_deleted=false;


}
