# Блокирующие очереди пакета concurrent

Пакет java.util.concurrent включает классы для формирования блокирующих очередей с поддержкой  
многопоточности. Блокирующие очереди используются в тех случаях, когда нужно выполнить  
(проверить выполненение) какие-либо условия для продолжения потоками своей работы. Блокирующие  
очереди могут реализовывать интерфейсы BlockingQueue, BlockingDeque, TransferQueue. В пакете  
java.util.concurrent имеются следующие реализации блокирующих очередей :

Характеристики BlockingQueue:
 - BlockingQueue не принимает элементы null, если вы намеренно добавите элемент null в эту очередь,
будет выдано исключение NullPointerException.
 - BlockingQueue может быть ограничена по емкости. Метод remainingCapacity() возвращает оставшуюся 
   емкость этой очереди или Integer.MAX_VALUE, если емкость очереди не ограничена.
 - BlockingQueue обычно используется в приложениях типа Producer & Consumer (производитель и 
   потребитель). BlockingQueue является потомком интерфейса Collection, поэтому также  
   поддерживается метод remove(e). Однако такие методы работают неэффективно и только для  
   случайного использования. Например, удалите дефектный товар из очереди.
 - BlockingQueue - это потокобезопасная очередь (thread-safe). Все методы очереди являются 
   атомарными операциями (Atomic Operations). Однако методы, унаследованные от интерфейса  
   Collection, такие как addAll, containsAll, retainAll и removeAll , не обязательно являются  
   атомарными операциями, это зависит от класса, реализующего интерфейс BockingQueue. Таким  
   образом, возможно, например, вызов addAll(aCollection) может вызвать исключение, если другой  
   поток одновременно добавляет элемент aCollection.
 - BlockingQueue не поддерживает такие методы, как "close" (закрыть) или  "shutdown" (завершение 
   работы), например, когда Producer (производитель) хочет отправить сигнал о том, что в очередь 
   больше не будут добавлены "продукты". Необходимость и использование этих функций, как правило,
   зависят от реализации. Решение может быть следующим: Конечный и специальный "продукт"  
   добавляется в очередь в качестве сигнала, сообщающего Consumer (потребителю), что это  
   последний продукт, добавляемый в очередь.

ArrayBlockingQueue — очередь, реализующая классический кольцевой буфер;
LinkedBlockingQueue — односторонняя очередь на связанных узлах;
LinkedBlockingDeque — двунаправленная очередь на связанных узлах;
SynchronousQueue — блокирующую очередь без емкости (операция добавления одного потока находится 
в  ожидании соответствующей операции удаления в другом потоке);
LinkedTransferQueue — реализация очереди на основе интерфейса TransferQueue;
DelayQueue — неограниченная блокирующая очередь, реализующая интерфейс Delayed;
PriorityBlockingQueue — реализация очереди на основе интерфейса PriorityQueue.
Использование очередей пакета java.util.concurrent может стать решением проблем взаимных 
блокировок  и «голодания».

примеры использования блокирующих очередей :

пример с блокирующей очередью ArrayBlockingQueue;
пример с двунаправленной очередью LinkedBlockingDeque;
пример использования SynchronousQueue.
пример использования LinkedTransferQueue.

Интерфейс BlockingQueue
Интерфейс BlockingQueue определяет блокирующую очередь, наследующую свойства интерфейса Queue, в 
которой элементы хранятся в порядке «первый пришел, первый вышел» (FIFO – first in, first out).  
Реализация данного интерфейса обеспечивает блокировку потока в двух случаях :

- при попытке получения элемента из пустой очереди;
- при попытке размещения элемента в полной очереди.

- Когда поток пытается получить элемент из пустой очереди, то он переводится в состояние ожидания  
до тех пор, пока какой-либо другой поток не разместит элемент в очереди. Аналогично при попытке  
положить элемент в полную очередь; поток ставится в ожидание до тех пор, пока другой поток не  
заберет элемент из очереди и, таким образом, не освободит место в ней. Естественно, понятие  
"полная очередь" подразумевает ограничение размера очереди.

BlockingQueue изящно решает проблему передачи собранных одним потоком элементов для обработки  в 
другой поток без явных хлопот о проблемах синхронизации.

Основные методы интерфейса BlockingQueue

|Метод	|Описание|
|-----------------|-------------------------|
|boolean add(E e)	|Немедленное добавление элемента в очередь, если это возможно; метод возвращает true при благополучном завершении операции, либо вызывает IllegalStateException, если очередь полная.|
|boolean contains(Object o)	|Проверка наличия объекта в очереди; если объект найден в очереди метод вернет true.|
|boolean offer(E e)	|Немедленное размещение элемента в очереди при наличие свободного места; метод вернет true при успешном завершении операции, в противном случае вернет false.|
|boolean offer(E e, long timeout, TimeUnit unit)	|Размещение элемента в очереди при наличии свободного места; при необходимости определенное ожидание времени, пока не освободиться место.|
|E poll(long timeout, TimeUnit unit)	|Чтение и удаление элемента из очереди в течение определенного времени (таймаута).|
|void put(E e)	|Размещение элемента в очереди, ожидание при необходимости освобождения свободного места.|
|int remainingCapacity()	|Получения количества элементов, которое можно разместить в очереди без блокировки, либо Integer.MAX_VALUE при отсутствии внутреннего предела.|
|boolean remove(Object o)	|Удаление объекта из очереди, если он в ней присутствует.|
|E take()	|Получение с удалением элемента из очереди, при необходимости ожидание пока элемент не станет доступным.|

BlockingQueue не признает нулевых элементов (null) и вызывает NullPointerException при попытке  
добавить или получить такой элемент. Нулевой элемент возвращает метод poll, если в течение  
таймаута не был размещен в очереди очередной элемент.

Методы BlockingQueue можно разделить на 4 группы, по-разному реагирующие на невозможность  
выполнения операции в текущий момент и откладывающие их выполнение на время : первые вызывают  
Exception, вторые возвращают определенное значение (null или false), третьи блокируют поток на  
неопределенное время до момента выполнения операции, четвертые блокируют поток на определенное  
время. Эти методы представлены в следующей таблице :

|           | Вызывает Exception|	Чтение значения|	Блокировка|	Чтение с задержкой|
|-----------|---------|----------|--------------------|------------------|
|Insert|	add(e)|	offer(e)	|put(e)	|offer(e, time, unit)|
|Remove	remove()	|poll()|	take()	|poll(time, unit)|
|Проверка	|element()	|peek()	|не применимый	|не применимый|



Интерфейс BlockingDeque
Интерфейс BlockingDeque, также, как и BlockingQueue, определяет блокирующую, но двунаправленную  
очередь, наследующую свойства интерфейса Deque и ориентированную на многопотоковое исполнение,  
не разрешающую нулевые элементы и с возможностью ограничения емкости. Реализации интерфейса  
BlockingDeque блокируют операции получения элементов, если очередь пустая, и добавления элемента 
в очередь, если она полная.

Методы BlockingDeque объединены в 4 группы, по-разному реагирующие на невозможность выполнения  
операции в текущий момент и откладывающие их выполнение на небольшое время : первые вызывают  
Exception, вторые возвращают определенное значение (null или false), третьи блокируют поток  на 
неопределенное время до момента выполнения операции, четвертые блокируют поток на определенное  
время. Методы представлены в следующей таблице :



| | |Первый Элемент (голова)| | |
|-----------|------------|-------------|---------------|---------------|
|    |Вызывает Exception	|Чтение значения	|Блокировка|	Чтение с задержкой|
|Insert|	addFirst(e)	|offerFirst(e)|	putFirst(e)|	offerFirst(e, time, unit)|
|Remove	|removeFirst()	|pollFirst()|	takeFirst()	|pollFirst(time, unit)|
|Проверка|	getFirst()	|peekFirst()|	не применимый	|не применимый|
| | |Последний Элемент (хвост)| | |
|Insert	|addLast(e)	|offerLast(e)|	putLast(e)	|offerLast(e, time, unit)|
|Remove	|removeLast()|	pollLast()	|takeLast()	|pollLast(time, unit)|
|Проверка|	addLast|	peekLast()	|не применимый	|не применимый|

Реализация BlockingDeque может использоваться непосредственно в качестве BlockingQueue  с 
механизмом FIFO. Следующие представленные в таблице методы и наследованные от интерфейса  
BlockingQueue, точно эквивалентны методам BlockingDeque :


|BlockingQueue method	|Equivalent BlockingDeque method|
|-----------------------|--------------------------------|
|Insert |
|add(e)|	addLast(e)|
|offer(e)|	offerLast(e)|
|put(e)|	putLast(e)|
|offer(e, time, unit)|	offerLast(e, time, unit)|
|Remove|
|remove()	|removeFirst()|
|poll()	|pollFirst()|
|take()	|takeFirst()|
|poll(time, unit)	|pollFirst(time, unit)|
|Examine (Проверка)|
|element()	|getFirst()|
|peek()|	peekFirst()|

Действия по размещению объекта в BlockingDeque выполняйте перед действиями проверки доступа 
или удаления элемента из очереди в другом потоке.