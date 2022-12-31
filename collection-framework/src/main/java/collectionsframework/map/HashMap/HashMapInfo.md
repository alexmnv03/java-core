# HashMap

Класс HashMap реализует интерфейс Map. Для каждой записи в хэш-карте вычисляется хэш-код, 
и эта запись вставляется в корзину со значением хэш-кода в качестве индекса. 
Каждая запись представляет собой пару ключ-значение. Корзина в HashMap может содержать более 
одной записи. Хороший алгоритм хэш-карты будет пытаться равномерно распределить элементы в хэш-карте. 
HashMap обладает постоянной производительностью по времени для базовых операций поиска,
вставки, удаления и манипулирования. 
Двумя наиболее важными факторами, влияющими на производительность HashMap, являются начальная 
емкость и коэффициент загрузки. Количество сегментов - это емкость, а показатель того, когда 
нужно увеличить эту емкость, - коэффициент загрузки. 
Хэш-карта работает быстрее по сравнению с хэш-таблицей.

Отображение. Структура данных для хранения связанных вместе пар “ключ-значение”. 
Хэширует только ключи, значения не хэшируются. Хэширование выполняется немного быстрее, 
чем вставка в дерево, поэтому данные отображение используется, когда не требуется отсортированный порядок ключей.

- Реализует интерфейс Map
- Нельзя сохранить 2 значения по одинаковым ключам, второе значение заменит первое
- Ключ и значение может быть null
- По умолчанию емкость (capacity) 16, коэффициент заполнения 0.75 (75%)
- Не синхронизирован.