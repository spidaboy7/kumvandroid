package com.ijuru.kumva;

import com.ijuru.kumva.search.OnlineSearch;
import com.ijuru.kumva.search.Search;

/**
 * An online Kumva dictionary
 */
public class Dictionary {
	private String url;
	private String name;
	private String kumvaVersion;
	private String definitionLang;
	private String meaningLang;
	
	/**
	 * Constructs a dictionary
	 * @param name the name
	 * @param url the base URL
	 */
	public Dictionary(String url, String name, String kumvaVersion, String definitionLang, String meaningLang) {
		this.url = url;
		this.name = name;
		this.kumvaVersion = kumvaVersion;
		this.definitionLang = definitionLang;
		this.meaningLang = meaningLang;
	}
	
	/**
	 * Gets the URL
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Gets the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the Kumva version string
	 * @return the kumvaVersion
	 */
	public String getKumvaVersion() {
		return kumvaVersion;
	}

	/**
	 * Gets the language code of definitions
	 * @return the definitionLanguage
	 */
	public String getDefinitionLang() {
		return definitionLang;
	}

	/**
	 * @return the meaningLang
	 */
	public String getMeaningLang() {
		return meaningLang;
	}

	/**
	 * Creates a new search which can query this dictionary
	 * @return the search
	 */
	public Search createSearch() {
		return new OnlineSearch(this.url);
	}
}
