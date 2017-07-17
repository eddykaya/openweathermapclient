![travis-ci build status](https://travis-ci.org/eddykaya/openweathermapclient.svg?branch=master)

# openweathermapclient
This a an easy to use java client for the [Openweathermap API](https://openweathermap.org/api)

## current features
* provide the current temperature at a given city

## how to include the jar in your project
1. Download or clone the repository and build the jar using `mvn clean install`
2. Import the jar into your own project

## how to use the client
### Maven projects
1. Add the following repository definition to your pom.xml:
```xml
<repositories>
		<repository>
				<id>sonatype-snapshots</id>
				<url>https://oss.sonatype.org/content/repositories/snapshots</url>
				<snapshots>
						<enabled>true</enabled>
				</snapshots>
		</repository>
</repositories>
```
2. Add the dependency to your pom.xml:
```xml
<dependency>
		<groupId>com.github.eddykaya</groupId>
		<artifactId>openweathermapclient</artifactId>
		<version>0.0.1-SNAPSHOT</version>
</dependency>
```

### Non Maven projects
The main class to use is `OpenWeatherClient` which provides the following methods:
```java
public Optional<CurrentWeather> fetchCurrentWeatherAt(String city, Locale country)
```
## Example:

```java

package de.eddykaya.openweather.client;

import java.util.Locale;
import java.util.Optional;

import de.eddykaya.openweather.entities.external.CurrentWeather;

public class Main {

	public static void main(String[] args) {
		OpenWeatherClient client = new OpenWeatherClient(""); // provide your API key here
		Optional<CurrentWeather> currentWeather = client.fetchCurrentWeatherAt("Stuttgart", Locale.GERMANY);
		System.out.println(currentWeather.get());
	}

}


```
