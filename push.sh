#!/bin/sh
git add .
git commit -m a
git push
echo push ok
ssh root@ticknick.me ./caffeine_deploy
