# Очередь LinkedBlockingDeque

Класс LinkedBlockingDeque создает двунаправленную очередь с реализацией интерфейса BlockingDeque, наследуемого от интерфейса Deque. Данный класс может иметь ограничение на количество элементов в очереди. Если ограничение не задано, то оно равно значению Integer.MAX_VALUE.

// Конструкторы класса

LinkedBlockingDeque()
LinkedBlockingDeque(int capacity)
LinkedBlockingDeque(Collection<? extends E> c)
Класс LinkedBlockingDeque и его iterator реализуют все опциональные методы Collection и Iterator.

Элементы в двустороннюю очередь LinkedBlockingDeque можно добавлять при помощи следующих методов :

boolean add(E e)
void addFirst(E e)
void addLast(E e)
Метод add() аналогичен методу addLast(). В случае нехватки места в двусторонней очереди вызывается исключение IllegalStateException. Элементы можно также добавить при помощи следующих методов :

boolean offer(E e)
boolean offerFirst(E e)
boolean offerLast(E e)
В отличие от добавления элементов при помощи метода addXXX(), при добавлении элементов методом offerXXX() возвращается false, если элемент не может быть добавлен. Для удаления элементов имеются методы :

remove(), removeFirst(), removeLast()
poll(), pollFirst(), pollLast()
Методы removeXXX() выбрасывают исключение NoSuchElementException при пустой двусторонней очереди. Методы pollXXX() используются для чтения с удалением и возвращают значение null, если очередь пуста.

Несмотря на то, что работа с двусторонними очередями предполагает удаление элементов только с концов очереди, можно удалять определенный объект очереди при помощи следующих методов :

boolean remove(Object o)
boolean removeFirstOccurrence(Object o)
boolean removeLastOccurrence(Object o)
Так как концептуально двусторонняя очередь является привязанной с двух сторон, то можно проводить поиск элементов в любом порядке. Итератор iterator() можно использовать для поиска элементов с начала до конца, а descendingIterator() — для поиска элементов в обратном направлении с конца до начала. Однако нельзя получить доступ к элементу по его местоположению.

Метод toArray() возвращает массив элементов очереди типа Object[]. Полная англоязычная документация класса LinkedBlockingDeque представлена здесь.

В каких случаях нужны двусторонние очереди? Этот тип очереди позволяет сформировать удобные структуры данных при использовании рекурсивных процедур, как, например, работа с лабиринтами и разбор исходных данных. Так, при разборе исходных данных, можно сохранять правильные варианты в очереди, добавляя их с одной стороны. Если вариант при проверке оказывается неверным, то он удаляется, возвращаясь к последнему верному элементу. В этом случае используется только одна сторона очереди, как в стеке. При достижении «дна» необходимо вернуться в начало для получения решения, которое начинается с последнего элемента. Другим типичным примером является планировщик заданий в операционной системе.

Нижеприведенный пример демонстрирует использование интерфейса BlockingDeque, а вернее его реализацию — класса LinkedBlockingDeque с установленными границами. Это далеко не лучший пример использования двусторонней очереди, но он позволяет показать применение API и возникающие при достижении предела очереди события.
