@echo
==================================
git remote add leadrepo https://github.com/LostFinders/LostFinder
git stash
git fetch leadrepo
git merge leadrepo/master
git push myforkrepo master