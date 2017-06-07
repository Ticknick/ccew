#!/bin/sh
git add .

if [ $? -eq 0 ]
then echo ok
else
    echo error
    exit 1
fi

git commit -m a

if [ $? -eq 0 ]
then echo ok
else
    echo error
    exit 1
fi

git push

if [ $? -eq 0 ]
then echo ok
else
    echo error
    exit 1
fi

echo push ok
ssh root@ticknick.me ./caffeine_deploy
