package com.chat.features.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * FeatureRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-02-28T05:48:51.547359200-05:00[America/Toronto]")
public class FeatureRequest   {
  @JsonProperty("title")
  private String title;

  @JsonProperty("description")
  private String description;

  /**
   * Gets or Sets brand
   */
  public enum BrandEnum {
    ROGERS("Rogers"),
    
    FIDO("Fido"),
    
    CHATR("Chatr");

    private String value;

    BrandEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static BrandEnum fromValue(String value) {
      for (BrandEnum b : BrandEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("brand")
  private BrandEnum brand;

  @JsonProperty("launchDate")
  private String launchDate;

  @JsonProperty("launchYear")
  private Integer launchYear;

  /**
   * Gets or Sets launchQuarter
   */
  public enum LaunchQuarterEnum {
    Q1("Q1"),
    
    Q2("Q2"),
    
    Q3("Q3"),
    
    Q4("Q4");

    private String value;

    LaunchQuarterEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LaunchQuarterEnum fromValue(String value) {
      for (LaunchQuarterEnum b : LaunchQuarterEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("launchQuarter")
  private LaunchQuarterEnum launchQuarter;

  @JsonProperty("productOwner")
  private String productOwner;

  @JsonProperty("businessValue")
  private String businessValue;

  @JsonProperty("expectedRoi")
  private String expectedRoi;

  public FeatureRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * minimum: 1
   * maximum: 100
   * @return title
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@DecimalMin("1") @DecimalMax("100") 
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public FeatureRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * minimum: 1
   * maximum: 100
   * @return description
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@DecimalMin("1") @DecimalMax("100") 
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public FeatureRequest brand(BrandEnum brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Get brand
   * @return brand
  */
  @ApiModelProperty(example = "Rogers", required = true, value = "")


  public BrandEnum getBrand() {
    return brand;
  }

  public void setBrand(BrandEnum brand) {
    this.brand = brand;
  }

  public FeatureRequest launchDate(String launchDate) {
    this.launchDate = launchDate;
    return this;
  }

  /**
   * Launch date timestamp
   * @return launchDate
  */
  @ApiModelProperty(example = "2021-08-29T09:12:33.001Z", required = true, value = "Launch date timestamp")
  @NotNull


  public String getLaunchDate() {
    return launchDate;
  }

  public void setLaunchDate(String launchDate) {
    this.launchDate = launchDate;
  }

  public FeatureRequest launchYear(Integer launchYear) {
    this.launchYear = launchYear;
    return this;
  }

  /**
   * Get launchYear
   * @return launchYear
  */
  @ApiModelProperty(example = "2021", required = true, value = "")
  @NotNull


  public Integer getLaunchYear() {
    return launchYear;
  }

  public void setLaunchYear(Integer launchYear) {
    this.launchYear = launchYear;
  }

  public FeatureRequest launchQuarter(LaunchQuarterEnum launchQuarter) {
    this.launchQuarter = launchQuarter;
    return this;
  }

  /**
   * Get launchQuarter
   * @return launchQuarter
  */
  @ApiModelProperty(example = "Q1", required = true, value = "")
  @NotNull


  public LaunchQuarterEnum getLaunchQuarter() {
    return launchQuarter;
  }

  public void setLaunchQuarter(LaunchQuarterEnum launchQuarter) {
    this.launchQuarter = launchQuarter;
  }

  public FeatureRequest productOwner(String productOwner) {
    this.productOwner = productOwner;
    return this;
  }

  /**
   * Get productOwner
   * minimum: 1
   * maximum: 20
   * @return productOwner
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@DecimalMin("1") @DecimalMax("20") 
  public String getProductOwner() {
    return productOwner;
  }

  public void setProductOwner(String productOwner) {
    this.productOwner = productOwner;
  }

  public FeatureRequest businessValue(String businessValue) {
    this.businessValue = businessValue;
    return this;
  }

  /**
   * Get businessValue
   * minimum: 1
   * maximum: 2000
   * @return businessValue
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@DecimalMin("1") @DecimalMax("2000") 
  public String getBusinessValue() {
    return businessValue;
  }

  public void setBusinessValue(String businessValue) {
    this.businessValue = businessValue;
  }

  public FeatureRequest expectedRoi(String expectedRoi) {
    this.expectedRoi = expectedRoi;
    return this;
  }

  /**
   * Get expectedRoi
   * minimum: 1
   * maximum: 100
   * @return expectedRoi
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@DecimalMin("1") @DecimalMax("100") 
  public String getExpectedRoi() {
    return expectedRoi;
  }

  public void setExpectedRoi(String expectedRoi) {
    this.expectedRoi = expectedRoi;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeatureRequest featureRequest = (FeatureRequest) o;
    return Objects.equals(this.title, featureRequest.title) &&
        Objects.equals(this.description, featureRequest.description) &&
        Objects.equals(this.brand, featureRequest.brand) &&
        Objects.equals(this.launchDate, featureRequest.launchDate) &&
        Objects.equals(this.launchYear, featureRequest.launchYear) &&
        Objects.equals(this.launchQuarter, featureRequest.launchQuarter) &&
        Objects.equals(this.productOwner, featureRequest.productOwner) &&
        Objects.equals(this.businessValue, featureRequest.businessValue) &&
        Objects.equals(this.expectedRoi, featureRequest.expectedRoi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, brand, launchDate, launchYear, launchQuarter, productOwner, businessValue, expectedRoi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeatureRequest {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    launchDate: ").append(toIndentedString(launchDate)).append("\n");
    sb.append("    launchYear: ").append(toIndentedString(launchYear)).append("\n");
    sb.append("    launchQuarter: ").append(toIndentedString(launchQuarter)).append("\n");
    sb.append("    productOwner: ").append(toIndentedString(productOwner)).append("\n");
    sb.append("    businessValue: ").append(toIndentedString(businessValue)).append("\n");
    sb.append("    expectedRoi: ").append(toIndentedString(expectedRoi)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

