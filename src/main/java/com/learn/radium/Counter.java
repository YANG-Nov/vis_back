package com.learn.radium;


import cn.hutool.core.io.FileUtil;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2021-11-07 00:11:05
 */
public class Counter {

    /**
     * 同意替换
     * a huge step, a big leap, 飞跃
     * a number of, substantial, a large quantity of, plenty of, an enormous amount of, immense, vast, 大量的
     * abandon, give up, 放弃
     * accurate, exact, specific, 准确的, 具体的
     * adapt to, tune to, 协调, 适应
     * address, tackle, deal with, 应对, 处理
     * advocate for, call for, promote, argue, suggest, maintain, 宣传, 主张
     * apply to, 适用于
     * approach, means, measures, 方法
     * attention and admiration, 关注
     * average, ordinary people, 普通人
     * barrier, obstacle, difficulty, challenge, 困难
     * be committed to, be dedicated to, 致力于, 献身于
     * be credited to, be attributed to, 归功于, 归因于
     * be inclined to, tend to, 倾向于
     * be relevant to, be associated to, be linked with, 与…有关
     * broaden one’s horizon, extend one’s outlook, 拓宽视野
     * busy, have a tight timetable, 忙
     * cater for, satisfy, v.满足
     * change, vary, alter, transform, convert, shift, 改变, reverse, 扭转
     * cherish, value, care, 珍惜, 在乎
     * commercial, economic, 商业的, 经济的
     * feasible, practical, 可行的
     * compensate, make up, 补偿
     * competition, rivalry, 竞争
     * concentrate on, focus on, 专注于
     * consumption, expenditure, 消费, 开支
     * content, satisfied, adj.满足
     * contradictory, conflicting, 矛盾的
     * cooperation, teamwork, 合作
     * course, session, seminar, subject, discipline, 课程
     * cranky and annoyed, 烦人的
     * cultivate foster, nourish, 培养
     * decrease, lower, v.降低
     * dedication, commitment, 奉献
     * demolish, knock down, 拆除
     * difference, divergence, distinction, 区别, 不同之处
     * different, distinctive, various, varying, 不同的
     * discrimination, 歧视, prejudice, bias, 偏见
     * disseminate, transmit, 传播
     * domain, sphere, field, 领域
     * earn a living, support oneself economically, 谋生
     * eligible for, appropriate, 合格的
     * employ, hire, recruit, 征聘
     * enable, allow sb to do, 使…能够
     * endure, persist, 坚持, 忍耐
     * enough, sufficient, adequate, 充足的
     * ensure, make sure, 保证
     * enterprise, corporation company, 企业, 公司
     * enthusiasm, passion, 热情 enthusiastic, passionate, 热情的
     * environment-friendly, sustainable, 环保的
     * equate to, 等于
     * event, fair, 事件
     * experience difficult time, be in trouble, 处于困难
     * feel lonely, feel emotionally isolated, 孤单
     * flexible, resilient, 灵活的, 有弹性的
     * fragile, vulnerable, 脆弱的
     * frustrated, devastated, 受挫的
     * fulfillment, achievement, accomplishment, 成就
     * generate, create, produce a problem, 产生问题
     * get a good feeling, feel happy, achiever happiness, 感到幸福
     * have health problems, suffer poor health, 身体不好
     * have, get, access to, obtain, possess, gain, achieve, 获得, 占有, 得到
     * identify, recognize, detect, 识别, 发现
     * impact, effect, influence, 影响
     * implement, carry out, 实施
     * important, valuable, 重要的
     * important, prominent, major, main, dominant, key, 主要的, 大的
     * impressive and special 印象深刻的
     * in the absences of , without , lack of, 缺乏
     * indispensable, necessary, 不可缺少的
     * it takes, last for, 花…时间
     * justifiable, reasonable, legitimate, valid, 合力的, 正当的
     * life expectancy, 平均寿命, life span, longevity
     * likely, subject to, prone to, 易于
     * local, native, 本地的
     * mandatory, compulsory, 规定的, 必须的
     * maximize, optimize, 最大化, 优化
     * mission, goal, objective, 使命, 目标
     * need, require, 需要
     * nervous and worried, 焦虑
     * obesity, overweight, 肥胖症, 超重
     * obsolete, unfashionable, out of date, 过时的,
     * only, solely, simply, just, 仅仅
     * opponent, rival, challenger, 反对者
     * option, opt for, choice, choose, 选择
     * organization, agency, body, department, 组织, 机构
     * outstand, excel, 杰出
     * participate, get involved in, be engaged in, 参与
     * particular, certain, 某些, 某个
     * popularity, ubiquity, 普及
     * polluted, toxic, poisoned, contaminated, 被污染的
     * possible, potential, underlying, 潜在的
     * practical, specialist, professional knowledge, 专业知识
     * profound, thorough, 深刻的, 根本的
     * proponent, supporter, advocator, 支持者
     * protect, conserve, preserve, safeguard, 保护
     * provide, supply, offer, 提供
     * proximate, close, nearby, 紧邻
     * recognition, acceptance, 认可
     * regarding, concerning, as for, 关于
     * reject, refuse, turn down, 拒绝
     * rely on, depend on, 依赖
     * sacrifice, cost, 代价
     * same, equivalent, 相等的, 相同的
     * seek to, aspire to, 追求
     * serve, function, 起作用
     * setting, environment, surrounding, context, 环境
     * short, lived, non, durable, 是周期缩短
     * situation, circumstance, case, 状况, 条件
     * sometimes, from time to time, 有时
     * spectator, audience, 观众
     * start, initiate, 发起
     * stop, prevent, 阻止
     * hinder, deter, 威慑
     * strengthen, enhance, consolidate, underpin, 加强
     * stress and anxiety, 压力
     * strive for, endeavor for, 争取
     * substitute, replace, take the place of, 代替
     * suggestion, advice, recommendation, 建议
     * suitable for, appropriate, fitting, 适合的
     * surplus, excess, 过剩
     * tactic, strategy, 策略
     * talk, converse, communicate, chat, 交流
     * target, aim, purpose, 目标
     * theory, principle, 理论, 原理
     * treatment, therapy, 治疗
     * use, harness, utilize, employ, deploy, apply, 使用, 应用, 利用
     * variety, type, kind, 种类
     * vivid and dynamic, 生动的
     * vulnerable, fragile, 脆弱的
     */
    public static void getUserName() {

    }

    /**
     * dominate v. 控制 dominant adj. 主要的
     * monopolize v. monopoly n. 垄断
     * isolate v. isolation n. 隔离, 隔绝
     * interact, interaction, 互动, 互相作用
     * distract, distraction, 分散
     * attract, attraction, 吸引
     * creativity, n. 创造力, creative adj. create v. creation n.
     * flexibility, n. 灵活性, flexible adj.
     * persevere v. 坚持 perseverance n.
     * motivation 动力, 积极性 motivate 激发积极性 motivated
     * ambition n. 抱负 ambitious adj.
     * depressed 抑郁的, depressing 令人抑郁的
     * diversify v. diverse adj. diversity n. 多元
     * geography, geographic 地理的
     * preserve v. 保存 preservation n.
     * productivity n. 生产力, product n. 产品, production n. 生产, productive adj. 多产的, 有成效的
     * solidity n. solid v. 坚固
     * athlete, athletic 运动员, 体育的
     * nutrition, nutrient, nutritious 营养
     * donate, donation, 捐款
     * conserve, conservation, 保护
     * degradation n. degrade v. 退化
     * deceive v. deceptive adj. 欺骗
     * verification n. verify v. 核实
     * interpretation n. interpret v. 解释, 理解
     */
    public static void convertWord() {

    }

    /**
     * Some people say that the best way to improve public health is increasing the number of sports facilities.
     * Others, however, say that this would have little effect on public health and that other measures are required.
     * Discuss both these views and give your own opinion.
     * <p>
     * A problem of modern societies is the declining level of health in the general population, with conflicting views on how to tackle this worrying trend.
     * One possible solution is to provide more sports facilities to encourage a more active lifestyle.
     * <p>
     * Advocates of this believe that today's sedentary lifestyle and stressful working conditions mean that physical activity is no longer part of either our work or our leisure time.
     * If there were easy-to-reach local sports centres, we would be more likely to make exercise a regular part of our lives, rather than just collapsing in front of a screen every evening.
     * The variety of sports that could be offered would cater for all ages, levels of fitness and interests: those with painful memories of PE at school might be happier in the swimming pool than on the football pitch.
     * <p>
     * However, there may be better ways of tackling this problem.
     * Interest in sport is not universal, and additional facilities might simply attract the already fit, not those who most need them.
     * Physical activity could be encouraged relatively cheaply, for example by installing exercise equipment in parks, as my local council has done.
     * This has the added benefit that parents and children often use them together just for fun, which develops a positive attitude to exercise at an early age.
     * <p>
     * As well as physical activity, high tax penalties could be imposed on high-fat food products, tobacco and alcohol, as excessive consumption of any of these contributes to poor health.
     * Even improving public transport would help: it takes longer to walk to the bus stop than to the car.
     * <p>
     * In my opinion, focusing on sports facilities is too narrow an approach and would not have the desired results.
     * People should be encouraged not only to be more physically active but also to adopt a healthier lifestyle in general.
     */
    public static void writer01() {

    }

    /**
     * Some people say that the only reason for learning a foreign language is in order to travel to or work in a foreign country.
     * Others say that these are not the only reasons why someone should learn a foreign language.
     * Discuss both these views and give your own opinion.
     * <p>
     * Many may say, and I agree, that today's society has almost erased all its boarders and soon will become limitless in what concerns traveling for both work and pleasure.
     * Therefore, if this is to happen, then learning a new language is necessary.
     * <p>
     * Nowadays, learning a new language for the purpose of working in other countries seems to become more and more popular.
     * Adults in need of money or recognition are trying to pursue their happiness far away from home.
     * Also, the hey days of employers looking only for capable people have gone.
     * It seems that today's employers are looking not only for multi-skilled employees, but they also want people who know more than their mother tongue.
     * Sooner or later, those who omitted learning more are prone to become jobless.
     * <p>
     * However, to my mind, a new language should not be learned just for travelling or working in a foreign country.
     * A foreign language should help the learner broaden his mind.
     * By this I mean that the new language should and will allow us to understand more about the world itself, and maybe our ancestors' ways of thinking and acting.
     * Needless to say, knowing another language will help us when it comes to understanding the human race, because language is the first poem of the country.
     * <p>
     * All of this being said, I believe that learning a different language should be not only for satisfying our physical needs, like money, but also our moral needs, because never before had such a big thirst for knowledge been displayed.
     */
    public static void writer02() {

    }

    /**
     * In some countries young people are encouraged to work or travel for a year between finishing high school and starting university studies.
     * Discuss the advantages and disadvantages for young people who decide to do this.
     * <p>
     * It is quite common these days for young people in many countries to have a break from studying after graduating from high school.
     * The trend is not restricted to rich students who have the money to travel, but is also evident among poorer students who choose to work and become economically independent for a period of time.
     * <p>
     * The reasons for this trend may involve the recognition that a young adult who passes directly from school to university is rather restricted in terms of general knowledge and experience of the world.
     * By contrast, those who have spent some time earning a living or traveling to other places, have a broader view of life and better personal resources to draw on.
     * They tend to be more independent, which is a very important factor in academic study and research, as well as giving them an advantage in terms of coping with the challenges of students life.
     * <p>
     * However, there are certainly dangers in taking time off at that important age.
     * Young adults may end up never returning to their studies or finding it difficult to readapt to an academic environment.
     * They may think that it is better to continue in a particular job, or to do something completely different from a university course.
     * But overall, I think this is less likely today, when academic qualifications are essential for getting a reasonable career.
     * <p>
     * My view is that young people should be encouraged to broaden their horizons.
     * That is the best way for them to get a clear perspective of what they are hoping to do with her lives and why.
     * Students with such a perspective are usually the most effective and motivated ones and taking a year off may be the best way to gain this.
     */
    public static void writer03() {

    }

    /**
     * In many countries schools have severe problems with student behaviour.
     * What do you think are the causes of this?
     * What solutions can you suggest?
     * <p>
     * In current society, schools are regarded as a place to guide children and protect them.
     * At the same time, children in schools are often thought to be docile.
     * However, they do not behave themselves as well as predict.
     * Personally speaking, multiple factors contribute to this phenomenon.
     * <p>
     * Firstly, education system is to blame.
     * To be specific, exam oriented learning gives priority to the classes related to tests, but ignores comprehensive development of a student.
     * In addition, teachers only concentrate on the academic performance or the learning outcome no matter what methods students adopt to compete with others.
     * To deal with this problem, extra-curriculum should be introduced.
     * For example, sport is recommended in improving students' team work.
     * Supposing students are allowed more opportunities to cooperate with their classmates, they would be more active and modest.
     * <p>
     * Secondly, children nowadays are obsessed with materialistic values.
     * In their eyes, the academic marks are not as important as whether their clothes are fashionable enough.
     * When they see a voguish cell phone in the advertisement, they think they have to follow the suit.
     * Otherwise, they would be mocked and even excluded by their classmates.
     * Efforts should be made by both parents and schools to tackle this tendency.
     * It is not wise to encourage and reward children according to their marks in final exams.
     * Besides, wearing uniform and eliminating anything irrelevant to learning in campus are also acceptable strategies.
     * <p>
     * To sum up, there are definitely many problems existing in schooling children and they are too young to behave themselves.
     * Fortunately, these problems can be addressed through attempts from family and teachers.
     */
    public static void writer04() {

    }

    /**
     * Increasing the price of petrol is the best way to solve growing traffic and pollution problems.
     * To what extent do your agree or disagree?
     * What other measures do you think might be effective?
     * <p>
     * There is no doubt that traffic and pollution from vehicles have become huge problems, both in cities and on motorways everywhere.
     * Solving these problems is likely to need more than a simple rise in the price of petrol.
     * <p>
     * While it is undeniable that private car use is one of the main causes of the increase in traffic and pollution, higher fuel costs are unlikely to limit the number of drivers for long.
     * As this policy would also affect the cost of public transport, it would be very unpopular with everyone who needs to travel on the roads.
     * But there are various other measures that could be implemented that would have a huge effect on these problems.
     * <p>
     * I think to tackle the problem of pollution, cleaner fuels need to be developed.
     * The technology is already available to produce electric cars that would be both quieter and cleaner to use.
     * Persuading manufactures and travelers to adopt this new technology would be a more effective strategy for improving air quality, especially in cities.
     * <p>
     * However, traffic congestion will not be solved by changing the type of private vehicle people can use.
     * To do this, we need to improve the choice of public transport services available to travelers.
     * For example, if sufficient sky trains and underground train systems were built and effectively maintained in our major cities, then traffic on the roads would be dramatically reduced.
     * Long-distance train and coach services should be made attractive and affordable alternatives to drive your own car for long journeys.
     * <p>
     * In conclusion, I think that long-term traffic and pollution reductions would depend on educating the public to use public transport more, and on governments using public money to construct and run efficient systems.
     */
    public static void writer05() {

    }

    /**
     * Some experts believe that it is better for children to begin learning a foreign language at primary school rather than secondary school.
     * Do the advantages of this outweigh the disadvantages?
     * <p>
     * Traditionally, children have begun studying foreign languages at secondary school, but introducing them earlier is recommended by some educationalists.
     * This policy has been adopted by some educational authorities or individual schools, with both positive and negative outcomes.
     * <p>
     * The obvious argument in its favour is that young children pick up languages much more easily than teenagers.
     * Their brains are still programmed to acquire their mother tongue, which facilitates learning another language, and unlike adolescents, they are not inhibited by self-consciousness.
     * <p>
     * The greater flexibility of the primary timetable allows for more frequent, shorter sessions and for a play-centred approach, thus maintaining learners’ enthusiasm and progress.
     * Their command of the language in later life will benefit from this early exposure, while learning other languages subsequently will be easier for them.
     * They may also gain a better understanding of other cultures.
     * <br>
     * <br>
     * There are, however, some disadvantages.
     * Primary school teachers are generalists, and may not have the necessary language skills themselves.
     * If specialists have to be brought in to deliver these sessions, the flexibility referred to above is diminished.
     * If primary language teaching is not standardised, secondary schools could be faced with a great variety of levels in different languages within their intake, resulting in a classroom experience which undoes the earlier gains.
     * There is no advantage if enthusiastic primary pupils become demotivated as soon as they change schools.
     * However, these issues can be addressed strategically within the policy adopted.
     * <p>
     * Anything which encourages language learning benefits society culturally and economically, and early exposure to language learning contributes to this.
     * Young children’s innate abilities should be harnessed to make these benefits more achievable.
     */
    public static void writer06() {

    }

    /**
     * Creative artists should always be given the freedom to express their own ideas (in words, pictures, music or film) in whichever way they wish.
     * There should be no government restrictions on what they do.
     * To what extent do your agree or disagree with this opinion?
     * <p>
     * I agree with the statement that there should be no government restriction on creative artists who express themselves in the way they do and that they must be given freedom for the same.
     * Expression has always been the keynote in a person's life.
     * It is the result of mere expression of our thoughts that we are able to communicate.
     * Restrictions on how we present our thoughts is senseless.
     * <p>
     * Creative artists play a major role in our society, be it the government, old people, the youth or the children.
     * Their works enlighten our minds, no matter it is factual or entertainment based.
     * It is deserving that after a day's work, when we want to take some time off for ourselves, we look out for some leisure.
     * For instance: either pleasant music or a family movie can soothe the mind.
     * Entertainment gives us an overview of a new side of life which every individual respects.
     * There is almost everything good in what is given to us through the media world which is made up of artists.
     * <p>
     * On the contrary, sometimes these artists tend to be unscrupulous.
     * They convert rumors into facts and present them before us.
     * This might impair the reputation of some illustrious people in today's society.
     * On such occasions, certain restrictions are understandable.
     * Nevertheless we all do know what is right or wrong.
     * Rules and regulations now always are the solution to how artists present their own ideas.
     * Hence it is doltish to be impetuous and the government should enforce alternative ways to control the media.
     * <p>
     * Respect for one's ideas is not only hypothetical but must be practiced: It is through respect that each one of us can be recognized as a unique person in the world.
     * This can be achieved by looking at the bright side of what media i.e. the creative artists display for us.
     * Not a day can go by when we don’t look out for colorful dreams or beautiful life which we can find through music, poetry, films, pictures that creative artists offer us.
     */
    public static void writer07() {

    }

    /**
     * Creative artists play a major role in our society, be it the government, old people, the youth or the children.
     * Their works enlighten our minds, no matter it is factual or entertainment based.
     * It is deserving that after a day's work, when we want to take some time off for ourselves, we look out for some leisure.
     * For instance: either pleasant music or a family movie can soothe the mind.
     * Entertainment gives us an overview of a new side of life which every individual respects.
     * There is almost everything good in what is given to us through the media world which is made up of artists.
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * Creative artists play a major role in our society, be it the government, old people, the youth or the children.
     * Their works enlighten our mind, no matter it is factual or entertainment based.
     * It is deserving that after a day's work, when we want to take some time off for ourselves, we look out for some leisure.
     * For instance: either pleasant music or a family movie can soothe the mind.
     * Entertainment gives us an overview of a new side of life which every individual respects.
     * There is almost everything good in what is given to us through the media world which is made up of artists.
     */
    public static void test() {

    }

    /**
     * OK. Good morning every professor, it is such an honor and pleasure for me to be here to attend this interview today.
     * My name is Weilei, I am originally from Nanning, which is the capital of Guangxi province.
     * I acquired my computer science and technology bachelor degree from GXU on 2004, and then I work on Huawei and IBM for software development.
     * In 2011 I started my graduate career on University of Chinese Academy of Sciences and finally I gained the Software Engineering Master degree in 2016.
     * After that I work as a Chief Data Officer on Wusong corporation, and I am currently as one of the founders of an AI company, responsible for Natural Language Processing.
     * Our vision is to use artificial intelligence technology to solve the problem of inefficient recruitment in the human resource industry.
     * <p>
     * I was really interested in computer science when I first started college, and after I went to graduate school, I realized that I developed more interest in neural networking.
     * So I took more machine learning and mining classes and later I joined My mentor’s big data and AI lab, doing research in time sequence algorithm.
     * I ended up with developing a system to predict future air quality for an environment protected corporation, and currently I providing technical support as a consultant for that company.
     * <p>
     * Being in the field for several years, I saw huge potential in neural network. Like there is just so much I can do with it!
     * So I found my interest overlapped very well with neural network and deep learning.
     * So I hope to join our university to start my doctor career to continue my research in neural network and deep learning, and hopefully also transitioning into the civil engineering field.
     * Yeah, that’s all. Thank you.
     */
    public static void self() {

    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(FileUtil.readUtf8String("/weilei/test/eng.txt").split(" ")).collect(Collectors.toSet()).size());
    }
}
