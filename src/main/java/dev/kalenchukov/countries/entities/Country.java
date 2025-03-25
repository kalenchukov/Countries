/*
 * Copyright © 2024-2025 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.countries.entities;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Country
{
	@NotNull
	private final String iso3166Alpha2;

	@NotNull
	private final String iso3166Alpha3;

	@NotNull
	private final String iso3166Numeric;

	@NotNull
	private final String fips;

	@NotNull
	private final String name;

	@NotNull
	private final String capital;

	@NotNull
	private final String continent;

	private final int population;

	public Country(
		@NotNull final String iso3166Alpha2,
		@NotNull final String iso3166Alpha3,
		@NotNull final String iso3166Numeric,
		@NotNull final String fips,
		@NotNull final String name,
		@NotNull final String capital,
		@NotNull final String continent,
		final int population
	)
	{
		this.iso3166Alpha2 = iso3166Alpha2;
		this.iso3166Alpha3 = iso3166Alpha3;
		this.iso3166Numeric = iso3166Numeric;
		this.fips = fips;
		this.name = name;
		this.capital = capital;
		this.continent = continent;
		this.population = population;
	}

	@NotNull
	public String getIso3166Alpha2()
	{
		return this.iso3166Alpha2;
	}

	@NotNull
	public String getIso3166Alpha3()
	{
		return this.iso3166Alpha3;
	}

	@NotNull
	public String getIso3166Numeric()
	{
		return this.iso3166Numeric;
	}

	@NotNull
	public String getFips()
	{
		return this.fips;
	}

	@NotNull
	public String getName()
	{
		return this.name;
	}

	@NotNull
	public String getCapital()
	{
		return this.capital;
	}

	@NotNull
	public String getContinent()
	{
		return this.continent;
	}

	public int getPopulation()
	{
		return this.population;
	}

	public static Country of(@NotNull final String iso3166Alpha2,
							 @NotNull final String iso3166Alpha3,
							 @NotNull final String iso3166Numeric,
							 @NotNull final String fips,
							 @NotNull final String name,
							 @NotNull final String capital,
							 @NotNull final String continent,
							 final int population)
	{
		return new Country(iso3166Alpha2, iso3166Alpha3, iso3166Numeric, fips, name, capital, continent, population);
	}

	@NotNull
	@Override
	public String toString()
	{
		return "Country{" +
			"iso3166Alpha2='" + this.iso3166Alpha2 + '\'' + ", " +
			"iso3166Alpha3='" + this.iso3166Alpha3 + '\'' + ", " +
			"iso3166Numeric='" + this.iso3166Numeric + '\'' + ", " +
			"fips='" + this.fips + '\'' + ", " +
			"name='" + this.name + '\'' + ", " +
			"capital='" + this.capital + '\'' + ", " +
			"continent='" + this.continent + '\'' + ", " +
			"population=" + this.population +
			'}';
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) {
			return true;
		}

		if (object == null || getClass() != object.getClass()) {
			return false;
		}

		Country country = (Country) object;

		return Objects.equals(name, country.name);
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(name);
	}
}
