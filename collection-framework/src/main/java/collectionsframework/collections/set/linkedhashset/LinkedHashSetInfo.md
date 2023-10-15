# LinkedHashSet
Множество сохраняющее значения в хэш таблицу в виде связанного списка с сохранением порядка ввода.

- Для хранения используется хэш таблица и связанный список.
- Значения хранятся в порядке вставки.
- Позволяет хранить любые значения в том числе и null.
- Не синхронизирован.

## Сравнение LinkedHashSet и HashSet

- Оба реализуют интерфейс Set.
- LinkedHashSet использует связанные списки, поэтому порядок вставки элементов сохраняется.
- LinkedHashSet использует больше пространства для хранения.
- LinkedHashSet работает медленней.

## Сравнение LinkedHashSet и TreeSet

- LinkedHashSet поддерживает порядок вставки, TreeSet реализует интерфейс SortedSet, поэтому 
элементы отсортированны.
- TreeSet обычно медленней, потому что при добавлении в него элементов необходимо выполнить 
  сортировку.
- LinkedHashSet позволяет вставить значения null, а TreeSet нет.


Конструкторы класса LinkedHashSet
1. LinkedHashSet(): этот конструктор используется для создания хэш-набора по умолчанию
LinkedHashSet<E> hs = new LinkedHashSet<E>();

2. LinkedHashSet(collection C): используется при инициализации HashSet с элементами коллекции C.
LinkedHashSet<E> hs = new LinkedHashSet<E>(Collection c);

3. LinkedHashSet(int size): используется для инициализации размера LinkedHashSet целым числом, указанным в параметре.
LinkedHashSet<E> hs = new LinkedHashSet<E>(int size);

4. LinkedHashSet(int capacity, float fillRatio): может использоваться для инициализации как емкости, 
так и коэффициента заполнения, также называемого пропускной способностью LinkedHashSet, 
с аргументами, указанными в параметре. Когда количество элементов превышает емкость хэш-набора, 
он умножается на коэффициент заполнения, тем самым увеличивая емкость LinkedHashSet.

LinkedHashSet<E> hs = new LinkedHashSet<E>(int capacity, int fillRatio);
