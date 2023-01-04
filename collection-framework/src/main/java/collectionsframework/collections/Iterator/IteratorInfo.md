# Iterator

Iterator - это один из способов обхода (traverse) элементов Collection. Ниже приведены характеристики Iterator:
Iterator не гарантирует порядок итераций элементов.
Iterator может разрешить удаление элементов из Collection во время итерации, что зависит от типа Collection.

Причина, по которой вы можете перемещаться  (traverse) по элементам of Collection 
с помощью Iterator, заключается в том, что Collection расширяется из интерфейса Iterable.
'''
// Definition of the Collection interface:
public interface Collection<E> extends Iterable<E>
'''
