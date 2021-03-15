--fun
--function myPower(x,y)
--
--    --return      y+x
--    return      "yiming", 37, false, "yimingl@hotmail.com"
--
--end
--
--power2 = myPower(2,3)
--
--print(power2)
--
--name, age,bGay = myPower()
--
--print(name,age,bGay)

--function isMyGirl(name)
--    return name == 'xiao6' , name
--end
--
--local bol,name = isMyGirl('xiao6')
--
--print(name,bol)

--anonymous function
--function newCounter()
--
--    local i = 0
--    return function()     -- anonymous function
--
--        i = i + 1
--
--        return i
--
--    end
--end
--
--
--
--c1 = newCounter()
--
--print(c1())  --> 1
--
--print(c1())  --> 2
--
--print(c1())

--table

--xiao6={}
--
--lucy = {name='xiao6',age=18,height=165.5}
--
--xiao6.age=35
--
--print(xiao6.name,xiao6.age,xiao6.height)
--
--print(xiao6)

-- 数组
--arr = {"string", 100, "xiao6",function() print("memeda") return 1 end}
--
--print(arr[4]())

--遍历
arr={1,2,3}
for k, v in pairs(arr) do

       print(k, v)
end


--面向对象
person = {name='xiao6',age = 18}

function  person.eat(food)

    print(person.name .." eating "..food)

end
person.eat("xxoo")