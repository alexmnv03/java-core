# TreeSet
Древовидное множество. Хранит отсортированную коллекцию в виде структуры красно-черного дерева.

- требуется не более log(n) времени для базовых операций (add, remove и contains)
- содержит только уникальные элементы
- данные хранятся в отсортированном порядке
- не допускает значение null
- довольно быстрое нахождение объектов (немного медленнее HashSet)
- не синхронизирован

Набор деревьев, как следует из названия, использует древовидную структуру для хранения элементов
и набор для упорядочения элементов. Порядок - это либо естественный порядок, либо порядок
с помощью компаратора, указанного при построении time. Набор деревьев не синхронизирован,
то есть, если несколько потоков хотят получить к нему доступ одновременно, нам нужно синхронизировать его извне.
