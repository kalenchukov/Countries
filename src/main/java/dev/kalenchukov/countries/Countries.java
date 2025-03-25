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

package dev.kalenchukov.countries;

import dev.kalenchukov.countries.entities.Country;
import dev.kalenchukov.countries.repositories.CountryRepositories;
import dev.kalenchukov.countries.repositories.CountryRepository;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Класс стран.
 *
 * @author Алексей Каленчуков.
 */
public final class Countries
{
	/**
	 * Репозиторий стран.
	 */
	@NotNull
	private static final CountryRepositories repository = new CountryRepository();

	/**
	 * Конструктор для {@code Countries}.
	 */
	private Countries() {}

	/**
	 * Возвращает количество стран.
	 *
	 * @return количество стран.
	 */
	public static int count()
	{
		return repository.count();
	}

	/**
	 * Выполняет проверку существования страны по названию.
	 *
	 * @param name название.
	 * @return {@code true}, если страна существует, иначе {@code false}.
	 */
	public static boolean exists(@NotNull final String name)
	{
		return repository.existsByName(name);
	}

	/**
	 * Возвращает страну по названию.
	 *
	 * @param name название.
	 * @return страну.
	 */
	@NotNull
	public static Country getByName(@NotNull final String name)
	{
		return repository.getByName(name);
	}

	/**
	 * Возвращает список всех стран.
	 *
	 * @return список всех стран.
	 */
	@NotNull
	public static Collection<@NotNull Country> getAll()
	{
		return repository.getAll();
	}
}
