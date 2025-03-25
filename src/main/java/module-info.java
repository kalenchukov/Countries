/**
 * Определяет API для получения информации о странах мира.
 */
module dev.kalenchukov.countries
{
	requires org.jetbrains.annotations;
	requires org.xerial.sqlitejdbc;

	exports dev.kalenchukov.countries;
	exports dev.kalenchukov.countries.entities;
	exports dev.kalenchukov.countries.exceptions;
}