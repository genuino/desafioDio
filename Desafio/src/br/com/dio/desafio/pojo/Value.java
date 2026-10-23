
package br.com.dio.desafio.pojo;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "paridadeCompra", "paridadeVenda", "cotacaoCompra", "cotacaoVenda", "dataHoraCotacao",
		"tipoBoletim" })
@Generated("jsonschema2pojo")
public class Value {

	@JsonProperty("paridadeCompra")
	private Double paridadeCompra;
	@JsonProperty("paridadeVenda")
	private Double paridadeVenda;
	@JsonProperty("cotacaoCompra")
	private Double cotacaoCompra;
	@JsonProperty("cotacaoVenda")
	private Double cotacaoVenda;
	@JsonProperty("dataHoraCotacao")
	private String dataHoraCotacao;
	@JsonProperty("tipoBoletim")
	private String tipoBoletim;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("paridadeCompra")
	public Double getParidadeCompra() {
		return paridadeCompra;
	}

	@JsonProperty("paridadeCompra")
	public void setParidadeCompra(Double paridadeCompra) {
		this.paridadeCompra = paridadeCompra;
	}

	@JsonProperty("paridadeVenda")
	public Double getParidadeVenda() {
		return paridadeVenda;
	}

	@JsonProperty("paridadeVenda")
	public void setParidadeVenda(Double paridadeVenda) {
		this.paridadeVenda = paridadeVenda;
	}

	@JsonProperty("cotacaoCompra")
	public Double getCotacaoCompra() {
		return cotacaoCompra;
	}

	@JsonProperty("cotacaoCompra")
	public void setCotacaoCompra(Double cotacaoCompra) {
		this.cotacaoCompra = cotacaoCompra;
	}

	@JsonProperty("cotacaoVenda")
	public Double getCotacaoVenda() {
		return cotacaoVenda;
	}

	@JsonProperty("cotacaoVenda")
	public void setCotacaoVenda(Double cotacaoVenda) {
		this.cotacaoVenda = cotacaoVenda;
	}

	@JsonProperty("dataHoraCotacao")
	public String getDataHoraCotacao() {
		return dataHoraCotacao;
	}

	@JsonProperty("dataHoraCotacao")
	public void setDataHoraCotacao(String dataHoraCotacao) {
		this.dataHoraCotacao = dataHoraCotacao;
	}

	@JsonProperty("tipoBoletim")
	public String getTipoBoletim() {
		return tipoBoletim;
	}

	@JsonProperty("tipoBoletim")
	public void setTipoBoletim(String tipoBoletim) {
		this.tipoBoletim = tipoBoletim;
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
