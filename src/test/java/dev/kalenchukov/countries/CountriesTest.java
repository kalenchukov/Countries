/*
 * Copyright © 2025 Алексей Каленчуков
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

package dev.kalenchukov.countries;

import dev.kalenchukov.countries.entities.Country;
import dev.kalenchukov.countries.exceptions.CountryNotFoundException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Класс проверки методов класса {@link Countries}.
 *
 * @author Алексей Каленчуков
 */
public class CountriesTest
{
	/**
	 * Класс проверки статических методов.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Static
	{
		/**
		 * Проверка метода {@link Countries#count()}.
		 */
		@Test
		public void count()
		{
			Integer actualCount = Countries.count();

			assertThat(actualCount).isPositive();
		}

		/**
		 * Проверка метода {@link Countries#getAll()}.
		 */
		@Test
		public void getAll()
		{
			Collection<Country> actualCountries = Countries.getAll();

			assertThat(actualCountries).isNotEmpty();
		}

		/**
		 * Класс проверки метода {@link Countries#exists(String)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class Exists
		{
			/**
			 * Проверка метода {@link Countries#exists(String)}.
			 */
			@Test
			public void exists()
			{
				Boolean actualExists = Countries.exists("Russia");

				assertThat(actualExists).isTrue();
			}

			/**
			 * Проверка метода {@link Countries#exists(String)} с пустым названием.
			 */
			@Test
			public void existsWithValueEmpty()
			{
				Boolean actualExists = Countries.exists("");

				assertThat(actualExists).isFalse();
			}

			/**
			 * Проверка метода {@link Countries#exists(String)} с некорректным названием.
			 */
			@Test
			public void existsWithValueIncorrect()
			{
				Boolean actualExists = Countries.exists("2343");

				assertThat(actualExists).isFalse();
			}
		}

		/**
		 * Класс проверки метода {@link Countries#exists(String)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class GetByName
		{
			/**
			 * Проверка метода {@link Countries#getByName(String)}.
			 */
			@Test
			public void getByName()
			{
				Country actualCountry = Countries.getByName("Russia");

				assertThat(actualCountry.getName()).isEqualTo("Russia");
			}

			/**
			 * Проверка метода {@link Countries#getByName(String) с несуществующим названием}.
			 */
			@Test
			public void getByNameWithNotExists()
			{
				assertThatExceptionOfType(CountryNotFoundException.class).isThrownBy(() -> {
					Countries.getByName("Россия");
				});
			}

			/**
			 * Проверка метода {@link Countries#getByName(String) с {@code null}}.
			 */
			@Test
			public void getByNameWithNull()
			{
				assertThatExceptionOfType(CountryNotFoundException.class).isThrownBy(() -> {
					Countries.getByName(null);
				});
			}
		}
	}
}