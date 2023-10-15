# List


Реализации этого интерфейса представляют собой упорядоченные коллекции. Кроме того, 
разработчику предоставляется возможность доступа к элементам коллекции по индексу и 
по значению (так как реализации позволяют хранить дубликаты, результатом поиска по 
значению будет первое найденное вхождение).

Отличие LinkedList от ArrayList:

LinkedList более эффективно работает с операцями вставки, удаления в середине списка, но менее 
эффективно с оперциями произвольного доступа. ArrayList наоборот более эффективно работает с 
оперциями произвольного доступа, но менне эффективно с операцями вставки, удаления в середине списка.

В LinkedList добавляются методы, которые позволяют использовать его как стек, очередь и двухстороннюю очередь.

## Содержание
 - [arraylist](https://github.com/alexmnv03/java-core/tree/develop/collection-framework/src/main/java/collectionsframework/collections/list/arraylist)
 - [linkedlist](https://github.com/alexmnv03/java-core/tree/develop/collection-framework/src/main/java/collectionsframework/collections/list/linkedlist)
