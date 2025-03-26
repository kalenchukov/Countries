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

package dev.kalenchukov.countries.services;

import dev.kalenchukov.countries.entities.Country;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Интерфейс для реализации сервиса стран.
 *
 * @author Алексей Каленчуков
 */
public interface CountryServices
{
	/**
	 * Возвращает количество стран.
	 *
	 * @return количество стран.
	 */
	int count();

	/**
	 * Выполняет проверку существования страны по названию.
	 *
	 * @param name название.
	 * @return {@code true}, если страна существует, иначе {@code false}.
	 */
	boolean existsByName(@NotNull String name);

	/**
	 * Возвращает список всех стран.
	 *
	 * @return список всех стран.
	 */
	@NotNull
	Collection<@NotNull Country> getAll();

	/**
	 * Возвращает страну по названию.
	 *
	 * @param name название.
	 * @return страну.
	 */
	@NotNull
	Country getByName(@NotNull String name);

	/**
	 * Добавляет страну в базу данных.
	 *
	 * @param country страна.
	 */
	void add(@NotNull Country country);

	/**
	 * Создаёт таблицу для стран.
	 */
	void create();
}
