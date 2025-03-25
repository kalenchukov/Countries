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

package dev.kalenchukov.countries.repositories;

import dev.kalenchukov.countries.entities.Country;
import dev.kalenchukov.countries.exceptions.CountryNotFoundException;
import dev.kalenchukov.countries.exceptions.DatabaseException;
import dev.kalenchukov.countries.modules.Database;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Класс репозитория стран.
 *
 * @author Алексей Каленчуков
 */
public class CountryRepository implements CountryRepositories
{
	/**
	 * Соединение с базой данных.
	 */
	@NotNull
	private final Connection connection;

	/**
	 * Конструктор для {@code CountryRepository}.
	 */
	public CountryRepository()
	{
		this.connection = Database.getConnection();
		this.create();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param name {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public Country getByName(@NotNull final String name)
	{
		String sql = """
			SELECT * FROM `countries` WHERE `name` = ? COLLATE NOCASE LIMIT 1
			""";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setString(1, name);
			statement.execute();

			ResultSet resultSet = statement.getResultSet();

			if (resultSet.next())
			{
				return Country.of(
					resultSet.getString("iso3166_alpha2"),
					resultSet.getString("iso3166_alpha3"),
					resultSet.getString("iso3166_numeric"),
					resultSet.getString("fips"),
					resultSet.getString("name"),
					resultSet.getString("capital"),
					resultSet.getString("continent"),
					resultSet.getInt("population")
				);
			}

			throw new CountryNotFoundException("Страна '" + name + "' не найдена.");
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public Collection<@NotNull Country> getAll()
	{
		Collection<Country> names = new ArrayList<>();

		String sql = "SELECT * FROM `countries`";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.execute();

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next())
			{
				names.add(
					Country.of(
						resultSet.getString("iso3166_alpha2"),
						resultSet.getString("iso3166_alpha3"),
						resultSet.getString("iso3166_numeric"),
						resultSet.getString("fips"),
						resultSet.getString("name"),
						resultSet.getString("capital"),
						resultSet.getString("continent"),
						resultSet.getInt("population")
					)
				);
			}
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}

		return names;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int count()
	{
		String sql = """
			SELECT COUNT(*) AS `count` FROM `countries`
			""";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			ResultSet resultSet = statement.getResultSet();
			resultSet.next();

			return resultSet.getInt("count");
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param name {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public boolean existsByName(@NotNull final String name)
	{
		int count = 0;

		String sql = """
			SELECT COUNT(*) AS `count` FROM `countries` WHERE `name` = ? COLLATE NOCASE LIMIT 1
			""";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, name);
			statement.execute();

			ResultSet resultSet = statement.getResultSet();
			resultSet.next();
			count = resultSet.getInt("count");
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}

		return (count != 0);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param country {@inheritDoc}
	 */
	@Override
	public void add(@NotNull final Country country)
	{
		String sql = """
			INSERT INTO countries (iso3166_alpha2, iso3166_alpha3, iso3166_numeric, fips, name, capital, continent, population)
			VALUES (?, ?, ?, ?, ?, ?, ?, ?)
			""";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setString(1, country.getIso3166Alpha2());
			statement.setString(2, country.getIso3166Alpha3());
			statement.setString(3, country.getIso3166Numeric());
			statement.setString(4, country.getFips());
			statement.setString(5, country.getName());
			statement.setString(6, country.getCapital());
			statement.setString(7, country.getContinent());
			statement.setInt(8, country.getPopulation());

			statement.execute();
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create()
	{
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE IF NOT EXISTS `countries` (");
		sql.append("`id` INTEGER NOT NULL");

		sql.append(", `iso3166_alpha2` TEXT NOT NULL");
		sql.append(", `iso3166_alpha3` TEXT NOT NULL");
		sql.append(", `iso3166_numeric` TEXT NOT NULL");
		sql.append(", `fips` TEXT NOT NULL");

		sql.append(", `name` TEXT NOT NULL");
		sql.append(", `capital` TEXT NOT NULL");
		sql.append(", `continent` TEXT NOT NULL");
		sql.append(", `population` INTEGER NOT NULL");

		sql.append(", PRIMARY KEY(`id`)");
		sql.append(", UNIQUE(`name`)");
		sql.append(")");

		try (Statement statement = connection.createStatement())
		{
			statement.execute(sql.toString());
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}
	}
}
