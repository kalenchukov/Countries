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

/**
 * Класс страны.
 */
public final class Country
{
	/**
	 * Буквенный код по стандарту ISO 3166 alpha 2.
	 */
	@NotNull
	private final String iso3166Alpha2;

	/**
	 * Буквенный код по стандарту ISO 3166 alpha 3.
	 */
	@NotNull
	private final String iso3166Alpha3;

	/**
	 * Цифровой код по стандарту ISO 3166 numeric.
	 */
	@NotNull
	private final String iso3166Numeric;

	/**
	 * Буквенный код по стандарту FIPS.
	 */
	@NotNull
	private final String fips;

	/**
	 * Название.
	 */
	@NotNull
	private final String name;

	/**
	 * Столица.
	 */
	@NotNull
	private final String capital;

	/**
	 * Континент расположения.
	 */
	@NotNull
	private final String continent;

	/**
	 * Численность населения.
	 */
	private final int population;

	/**
	 * Конструктор для {@code Country}.
	 *
	 * @param iso3166Alpha2 буквенный код по стандарту ISO 3166 alpha 2.
	 * @param iso3166Alpha3 буквенный код по стандарту ISO 3166 alpha 3.
	 * @param iso3166Numeric цифровой код по стандарту ISO 3166 numeric.
	 * @param fips буквенный код по стандарту FIPS.
	 * @param name название.
	 * @param capital столица.
	 * @param continent континент расположения.
	 * @param population численность населения.
	 */
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

	/**
	 * Возвращает буквенный код по стандарту ISO 3166 alpha 2.
	 *
	 * @return буквенный код по стандарту ISO 3166 alpha 2.
	 */
	@NotNull
	public String getIso3166Alpha2()
	{
		return this.iso3166Alpha2;
	}

	/**
	 * Возвращает буквенный код по стандарту ISO 3166 alpha 3.
	 *
	 * @return буквенный код по стандарту ISO 3166 alpha 3.
	 */
	@NotNull
	public String getIso3166Alpha3()
	{
		return this.iso3166Alpha3;
	}

	/**
	 * Возвращает цифровой код по стандарту ISO 3166 numeric.
	 *
	 * @return цифровой код по стандарту ISO 3166 numeric.
	 */
	@NotNull
	public String getIso3166Numeric()
	{
		return this.iso3166Numeric;
	}

	/**
	 * Возвращает буквенный код по стандарту FIPS.
	 *
	 * @return буквенный код по стандарту FIPS.
	 */
	@NotNull
	public String getFips()
	{
		return this.fips;
	}

	/**
	 * Возвращает название.
	 *
	 * @return название.
	 */
	@NotNull
	public String getName()
	{
		return this.name;
	}

	/**
	 * Возвращает столица.
	 *
	 * @return столица.
	 */
	@NotNull
	public String getCapital()
	{
		return this.capital;
	}

	/**
	 * Возвращает континент расположения.
	 *
	 * @return континент расположения.
	 */
	@NotNull
	public String getContinent()
	{
		return this.continent;
	}

	/**
	 * Возвращает численность населения.
	 *
	 * @return численность населения.
	 */
	public int getPopulation()
	{
		return this.population;
	}

	/**
	 * Создаёт страну.
	 *
	 * @param iso3166Alpha2 буквенный код по стандарту ISO 3166 alpha 2.
	 * @param iso3166Alpha3 буквенный код по стандарту ISO 3166 alpha 3.
	 * @param iso3166Numeric цифровой код по стандарту ISO 3166 numeric.
	 * @param fips буквенный код по стандарту FIPS.
	 * @param name название.
	 * @param capital столица.
	 * @param continent континент расположения.
	 * @param population численность населения.
	 * @return страну.
	 */
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

	/**
	 * Возвращает значение объекта в виде строки.
	 *
	 * @return строку.
	 * @see Object#toString()
	 */
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

	/**
	 * Проверяет равенство объектов.
	 *
	 * @param object сравниваемый объект.
	 * @return {@code true}, если объекты равны, иначе {@code false}.
	 */
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

	/**
	 * Возвращает значение объекта в виде числа.
	 *
	 * @return число.
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return Objects.hashCode(name);
	}
}
