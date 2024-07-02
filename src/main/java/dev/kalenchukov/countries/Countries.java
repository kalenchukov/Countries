package dev.kalenchukov.countries;

import dev.kalenchukov.countries.entities.Country;
import dev.kalenchukov.countries.repositories.CountryRepositories;
import dev.kalenchukov.countries.repositories.CountryRepository;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class Countries
{
	@NotNull
	private static final CountryRepositories repository = new CountryRepository();

	public static int count()
	{
		return repository.count();
	}

	public static boolean exists(@NotNull final String name)
	{
		return repository.existsByName(name);
	}

	@NotNull
	public static Country getByName(@NotNull final String name)
	{
		return repository.getByName(name);
	}

	@NotNull
	public static Collection<@NotNull Country> getAll()
	{
		return repository.getAll();
	}
}
