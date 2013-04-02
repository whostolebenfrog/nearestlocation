# nearestlocation

Java interop to allow the use of the clojure library clj-kdtree in a Java environment to find nearest locations to a point.
This can be used to store the lat, lng and names of cities, for example, and then find the nearest city for a given point.

An excellent free database of city or country location data that you may find useful can be found in the GeoLite databases from the company MaxMind.

## Usage

import com.github.nearestlocation.Locator;
import com.github.nearestlocation.types.Location;

...

Location bristol = new Location(51.45d, -2.5833d, "Bristol");
Location northVancouver = new Location(49.3167d, -123.0667d, "North Vancouver");

Locator locator = new Locator(Arays.asList(bristol, northVancouver));

Double someLat = 50;
Double someLng = -2;

Location nearestLocation = locator.getNearestLocation(someLat, someLng);

nearestLocation.lat; // 51.45
nearestLocation.lng; // -2.5833
(String) nearestLocation.name // "Bristol"

## License

Distributed under the Eclipse Public License, the same as Clojure.
