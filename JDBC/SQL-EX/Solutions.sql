
--Краткая информация о базе данных "Компьютерная фирма":

--Схема БД состоит из четырех таблиц:
--Product(maker, model, type)
--PC(code, model, speed, ram, hd, cd, price)
--Laptop(code, model, speed, ram, hd, price, screen)
--Printer(code, model, color, type, price)
--Таблица Product представляет производителя (maker), номер модели (model) и тип ('PC' - ПК, 'Laptop' - ПК-блокнот или 'Printer' - принтер).
--Предполагается, что номера моделей в таблице Product уникальны для всех производителей и типов продуктов
 --В таблице PC для каждого ПК, однозначно определяемого уникальным кодом – code, указаны модель – model (внешний ключ к таблице Product),
--скорость - speed (процессора в мегагерцах), объем памяти - ram (в мегабайтах), размер диска - hd (в гигабайтах),
--скорость считывающего устройства - cd (например, '4x') и цена - price. Таблица Laptop аналогична таблице РС за исключением того,
--что вместо скорости CD содержит размер экрана -screen (в дюймах). В таблице Printer для каждой модели принтера указывается,
--является ли он цветным - color ('y', если цветной), тип принтера - type (лазерный – 'Laser', струйный – 'Jet' или матричный – 'Matrix') и цена - price.

--10. Найдите модели принтеров, имеющих самую высокую цену. Вывести: model, price
Select printer.model, printer.price
from printer
where printer.price = (select max(price) from printer)

--11. Найдите среднюю скорость ПК.
Select avg(speed) from pc

--12. Найдите среднюю скорость ПК-блокнотов, цена которых превышает 1000 дол.
Select avg(speed) from Laptop
where price>1000

--13. Найдите среднюю скорость ПК, выпущенных производителем A.
Select avg(speed) from
PC join Product on PC.model = Product.model 
               and maker    = 'A'

--14. Найти производителей, которые выпускают более одной модели, при этом все выпускаемые производителем модели являются продуктами одного типа. Вывести: maker, type
select distinct maker, type from product
where maker in 
(select maker 
 from product
 group by maker
 having count(distinct type) = 1 
   and count(model) > 1
 )

--15. Найдите размеры жестких дисков, совпадающих у двух и более PC. Вывести: HD
select distinct hd from
PC p1
where hd in (select hd from pc p2 where p2.code <> p1.code )

--16. Найдите пары моделей PC, имеющих одинаковые скорость и RAM. В результате каждая пара указывается только один раз, т.е. (i,j), но не (j,i),
--   Порядок вывода: модель с большим номером, модель с меньшим номером, скорость и RAM.
Select distinct pc1.model, pc2.model, pc1.speed, pc1.ram 
from PC pc1 , PC pc2
where pc1.speed = pc2.speed 
  and pc1.ram = pc2.ram 
  and pc1.model>pc2.model
  
--17. Найдите модели ПК-блокнотов, скорость которых меньше скорости любого из ПК. Вывести: type, model, speed
Select distinct type, laptop.model, speed
from Laptop join product on laptop.model = product.model
where speed < all(select speed from pc)

--18. Найдите производителей самых дешевых цветных принтеров. Вывести: maker, price
Select distinct maker, price
from product join printer on product.model = printer.model
where price = (select min(price) from printer where color = 'y') 
  and color = 'y'

--19. Для каждого производителя, имеющего модели в таблице Laptop, найдите средний размер экрана выпускаемых им ПК-блокнотов. Вывести: maker, средний размер экрана.
Select maker, avg(screen)
from product join laptop on product.model = laptop.model
group by maker

--20. Найдите производителей, выпускающих по меньшей мере три различных модели ПК. Вывести: Maker, число моделей ПК.
Select maker, count(distinct product.model)
from product
group by maker, type
having type = 'PC' and count(distinct product.model)>=3

--21. Найдите максимальную цену ПК, выпускаемых каждым производителем, у которого есть модели в таблице PC. Вывести: maker, максимальная цена.
Select maker, max(price) from
product join pc on product.model = pc.model
group by 

--22. Для каждого значения скорости ПК, превышающего 600 МГц, определите среднюю цену ПК с такой же скоростью. Вывести: speed, средняя цена.
Select speed, avg(price) 
from pc
group by speed
having speed>600

--23. Найдите производителей, которые производили бы как ПК со скоростью не менее 750 МГц, так и ПК-блокноты со скоростью не менее 750 МГц. Вывести: Maker
select maker
from product join pc on product.model = pc.model and pc.speed >=750
intersect
select maker
from product join laptop on product.model = laptop.model and laptop.speed >= 750

--24. Перечислите номера моделей любых типов, имеющих самую высокую цену по всей имеющейся в базе данных продукции.
with tmpQuery as(

select model, price from pc
union
select model, price from laptop
union
select model, price from printer)

select model from tmpQuery
where price = (select max(price) from tmpQuery)

--25. Найдите производителей принтеров, которые производят ПК с наименьшим объемом RAM и с самым быстрым процессором среди всех ПК, имеющих наименьший объем RAM.
--    Вывести: Maker
select distinct maker 
from product 
where type = 'printer' 
  and maker in 
            (select maker 
			 from product as p join pc on p.model = pc.model 
			                   join ( select max(speed) as speed, ram 
							          from pc
									  where ram = (select min(ram) from pc)
									  group by ram
									) as a on a.speed = pc.speed 
									      and a.ram   = pc.ram
			)









