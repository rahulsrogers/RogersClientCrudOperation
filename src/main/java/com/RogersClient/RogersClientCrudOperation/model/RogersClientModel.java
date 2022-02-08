package com.RogersClient.RogersClientCrudOperation.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

//import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Entity
@Table
@ApiModel(description = "details about the models")
public class RogersClientModel {

  //  @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @PrimaryKey
    private int  guid;
   private String feature_title ;
    private String feature_description;
   private Brand brand;
   private Date launch_datetime;
    private int launch_year;
   private LaunchQuarter launch_quarter ;
   private String product_owner ;
   private String  business_value ;
    private String expected_roi ;
    private boolean is_deleted=false;







}
