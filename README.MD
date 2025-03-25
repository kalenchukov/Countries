# Справка
## Countries
Получение информации о странах мира.

## Использование
#### Получение количества стран

```java
Countries.count();
```

Результат выполнения:
```
250
```

#### Получение списка всех стран

```java
Countries.getAll();
```

Результат выполнения:
```
[
	Country{
		iso3166Alpha2='AF',
		iso3166Alpha3='AFG',
		iso3166Numeric='004',
		fips='AF',
		name='Afghanistan',
		capital='Kabul',
		continent='Asia',
		population=37172386
	},

	...,

	Country{
		iso3166Alpha2='ZW',
		iso3166Alpha3='ZWE',
		iso3166Numeric='716',
		fips='ZI',
		name='Zimbabwe',
		capital='Harare',
		continent='Africa',
		population=14439018
	}
]
```

#### Проверка существования страны

```java
Countries.exists("Russia");
```

Результат выполнения:
```
true
```

#### Получение информации о стране

```java
Countries.getByName("Russia");
```

Результат выполнения:
```
Country{
	iso3166Alpha2='RU',
	iso3166Alpha3='RUS',
	iso3166Numeric='643',
	fips='RS',
	name='Russia',
	capital='Moscow',
	continent='Europe',
	population=144478050
}
```
