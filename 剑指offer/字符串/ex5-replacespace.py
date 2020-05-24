
def replaceSpace(s):
    x = s.replace(" ", "%20")
    return x



def main():
    testStr = "I love coding!"
    news = replaceSpace(testStr)
    print(news)

main()
