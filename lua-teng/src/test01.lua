local function main()
 -- print("hello lua")

    -- num = 1024  number  Lua的数字只有double型 64bits

    --num = 3.0  number

   -- num = "周老师".."哈哈哈"   -- string

   -- num=null type:nil value:nil

    numTyep=type(num)

    print(num)
    print(numTyep)

end
-- 两个减号是行注释

--[[
 这是块注释
 这是块注释.
 Lua的数字只有double型，64bits

 --]]

   -- main()

--while

--local i = 0
--
--local max = 10
--
--while i <= max do
--    print(i)
--    i = i +1
--end

-- if
--local function main()
--
--
--    local age = 140
--
--    local sex = 'Male'
--
--
--    if age == 40 and sex =="Male" then
--        print(" 男人四十一枝花 ")
--    elseif age > 60 and sex ~="Female" then
--
--        print("old man without country!")
--    elseif age < 20 then
--        io.write("too young, too naive!\n")
--
--    else
--        print("Your age is "..age)
--    end
--
--end


-- 调用
--main()


sum = 0

for i = 100, 1, -2 do

    sum = sum + i
    print("sum is "..sum)
end