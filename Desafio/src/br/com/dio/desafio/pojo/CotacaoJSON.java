package br.com.dio.desafio.pojo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@odata.context", "value" })
@Generated("jsonschema2pojo")
public class CotacaoJSON {

	@JsonProperty("@odata.context")
	private String odataContext;
	@JsonProperty("value")
	private List<Value> value;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("@odata.context")
	public String getOdataContext() {
		return odataContext;
	}

	@JsonProperty("@odata.context")
	public void setOdataContext(String odataContext) {
		this.odataContext = odataContext;
	}

	@JsonProperty("value")
	public List<Value> getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(List<Value> value) {
		this.value = value;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
