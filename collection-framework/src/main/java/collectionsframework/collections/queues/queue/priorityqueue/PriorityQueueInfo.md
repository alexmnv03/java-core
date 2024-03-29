# PriorityQueue

Очередь по приоритету возвращает элементы в отсортированном порядке, после того как они были введены в произвольном порядке.

Основанна на структуре данных “куча” - это самоорганизующееся двоичное дерево, в котором операции ввода и удаления вызывают перемещение наименьшего элемента в корень, не тратя время на сортировку всех элементов очереди).

Например, мы хотим получить элементы в порядке возрастания. В этом случае голова очереди будет указывать на наименьший элемент. Когда элемент будет получен, следующий наименьший элемент станет головой очереди.
Элементы приоритетной очереди могут быть не отсортированы, однако элементы возвращаются в отсортированном порядке.

*** Обычно применяется для выполнения заданий в порядке приоритета (1 - наивысший приоритет). ***
Т.е. мы получаем значение в порядке приоритета
Приоритетные очереди помогают потребителям сначала получать сообщения с более высоким приоритетом, 
за которыми следуют сообщения с более низким приоритетом.
Если мы не указываем приоритет, то он задается по умолчанию.
Чтобы указть приоритет надо создать свой Comparator и передать его очереди

- Возвращает наименьший элемент в естественном порядке или в порядке заданном в конструкторе при 
создании очереди.
- Неограниченный размер
- Методы (offer, poll, remove(), add) добавления и извлечения из очереди выполняются за время O
  (log(n));
- методы remove(Object) и contains(Object) выполняются за линейное время;
- методы поиска информации (peek, element, size) выполняются за фиксированное время.
- Не допускает элементов NULL.
- Не синхронизирован.

PriorityQueue - это асинхронная очередь, поэтому вы не должны использовать ее в среде 
multithreading, вместо этого используйте потокобезопасный (thread-safe) класс PriorityBlockingQueue.
