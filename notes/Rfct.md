---
tags: [Notebooks/Books]
title: Rfct
created: '2019-10-15T08:12:53.968Z'
modified: '2019-10-15T08:31:07.172Z'
---

# Rfct

当你面对一个最需要重构的遗留系统时，其规模之大、历史之久、代码质量之差，常会使得添加单元测试或者理解其逻辑都成为不可能的任务。此时你唯一能依靠的就是那些已经被证明是**行为保持**的重构手法：用绝对安全的手法从“焦油坑”中整理出可测试的接口，给它添加测试，以此作为继续重构的立足点。

不改变软件行为”只是重构的最基本要求。要想真正让重构技术发挥威力，就必须做到“不需了解软件行为”——听起来很荒谬，但事实如此。如果一段代码能让你容易了解其行为，说明它还不是那么迫切需要被重构。那些最需要重构的代码，你只能看到其中的“坏味道”，接着选择对应的重构手法来消除这些“坏味道”，然后才有可能理解它的行为。而这整个过程之所以可行，全赖你在脑子里记录着一份“坏味道”与重构手法的对应表。

序

设计模式为重构提供了目标。然而“确定目标”只是问题的一部分而已，改造程序以达到目标，是另一个难题。

前言

按照目前对软件开发的理解，我们相信应该先设计而后编码：首先得有一个良好的设计，然后才能开始编码。但是，随着时间流逝，人们不断修改代码，于是根据原先设计所得的系统，整体结构逐渐衰弱。代码质量慢慢沉沦，编码工作从严谨的工程堕落为胡砍乱劈的随性行为。“重构”正好与此相反。哪怕你手上有一个糟糕的设计，甚至是一堆混乱的代码，你也可以借由重构将它加工成设计良好的代码。重构的每个步骤都很简单，甚至显得有些过于简单：你只需要把某个字段从一个类移到另一个类，把某些代码从一个函数拉出来构成另一个函数，或是在继承体系中把某些代码推上推下就行了。但是，**聚沙成塔，这些小小的修改累积起来就可以根本改善设计质量。这和一般常见的“软件会慢慢腐烂”的观点恰恰相反。**

# 第1章重构，第一个案例

因为尽管遵循重构手法可以使我避免绝大多数引入bug的情形，但我毕竟是人，毕竟有可能犯错。所以我需要可靠的测试。

重构技术就是以微小的步伐修改程序。如果你犯下错误，很容易便可发现它。

任何一个傻瓜都能写出计算机可以理解的代码。唯有写出人类容易理解的代码，才是优秀的程序员。

观察amountFor()时，我发现这个函数使用了来自Rental类的信息，却没有使用来自Customer类的信息。
这立刻使我怀疑它是否被放错了位置。绝大多数情况下，函数应该放在它所使用的数据的所属对象内，所以amountFor()应该移到Rental类去。

# 第2章重构原则

曾经有人这样问我：“重构就只是整理代码吗?”从某种角度来说，是的。但我认为重构不止于此，因为它提供了一种更高效且受控的代码整理技术。

重构的目的是使软件更容易被理解和修改。你可以在软件内部做很多修改，但必须对软件可观察的外部行为只造成很小变化，或甚至不造成变化。与之形成对比的是性能优化。和重构一样，性能优化通常不会改变组件的行为（除了执行速度），只会改变其内部结构。但是两者出发点不同：性能优化往往使代码较难理解，但为了得到所需的性能你不得不那么做。

无论何时你都应该清楚自己戴的是哪一顶帽子

为“擦掉窗户上的污垢，使你看得更远”。

# 第3章代码的坏味道

没有任何量度规矩比得上一个见识广博者的直觉

你应该更积极地分解函数。我们遵循这样一条原则：每当感觉需要以注释来说明点什么的时候，我们就把需要说明的东西写进一个独立函数中，并以其用途（而非实现手法）命名。

函数对某个类的兴趣高过对自己所处类的兴趣。这种孺慕之情最通常的焦点便是数据。

**复用常被视为对象的终极目的。不过我们认为，复用的意义经常被高估——大多数对象只要够用就好。**

# 第4章构筑测试体系

由于测试本来是可以正常运行的，所以我知道这个错误必定是在前一次执行测试后引入的。由于我频繁地进行测试，每次测试都在不久之前，因此我知道错误的源头就是我刚刚写下的代码。

# 第5章重构列表

重构的基本技巧——小步前进、频繁测试——已经得到多年的实践检验，特别是在Smalltalk社群中。

# 第6章重新组织函数

我的重构手法中，很大一部分是对函数进行整理，使之更恰当地包装代码。**几乎所有时刻，问题都源于LongMethods（过长函数）。**

ExtractMethod(110)是我最常用的重构手法之一。当我看见一个过长的函数或者一段需要注释才能让人理解用途的代码，我就会将这段代码放进一个独立函数中。

人们有时会问我，一个函数多长才算合适？在我看来，长度不是问题，关键在于函数名称和函数本体之间的语义距离。如果提炼可以强化代码的清晰度，那就去做，就算函数名称比提炼出来的代码还长也无所谓。

创造一个新函数，根据这个函数的意图来对它命名（以它“做什么”来命名，而不是以它“怎样做”命名）。