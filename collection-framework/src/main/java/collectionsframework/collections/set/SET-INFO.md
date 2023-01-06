# Интерфейс Set

Представляет собой неупорядоченную коллекцию, которая не может содержать дублирующиеся данные. Является программной моделью математического понятия «множество».
Set это неупорядоченный набор, и не позволяет содержать дубликаты.
Вы не може сказать про N-ый элемент и даже про первый элемент, так как он не имеет порядок.
Вы можете добавить или удалить элементы, и можете найти если элемент существует (Например "Находится ли 7 в данном наборе?").

Для применения Set в Джаве предусматриваются различные реализации:

- HashSet;
- TreeSet;
- LinkedHashSet.

Чем отличаются HashSet, LinkedHashSet и TreeSet
- HashSet хранит элементы в произвольном порядке, но зато быстро ищет. Подходит, если порядок Вам
  не важен, но важна скорость. Более того, для оптимизации поиска, HashSet будет хранить элементы так, как ему удобно.
- LinkedHashSet будет хранить элементы в порядке добавления, но зато работает медленнее.
- TreeSet хранит элементы отсортированными.


## Содержание
 - [enumset](https://github.com/alexmnv03/java-core/tree/develop/collection-framework/src/main/java/collectionsframework/collections/set/enumset)
 - [hashset](https://github.com/alexmnv03/java-core/tree/develop/collection-framework/src/main/java/collectionsframework/collections/set/hashset)
 - [linkedhashset](https://github.com/alexmnv03/java-core/tree/develop/collection-framework/src/main/java/collectionsframework/collections/set/linkedhashset)
 - [treeset](https://github.com/alexmnv03/java-core/tree/develop/collection-framework/src/main/java/collectionsframework/collections/set/treeset)
