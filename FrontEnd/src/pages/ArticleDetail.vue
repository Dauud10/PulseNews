<template>
  <div class="article-detail">
    <h1>{{ article.title }}</h1>
    <p>{{ article.description }}</p>
    <div class="article-content">
      <p>{{ article.content }}</p>
    </div>
    <!-- Display the article image -->
    <img :src="article.image" alt="Article Image" class="article-image" />
  </div>
</template>

<script>
export default {
  name: "ArticleDetailPage",
  props: ["id"], // Receiving the article id from the route params
  data() {
    return {
      article: {},
    };
  },
  created() {
    // Sample articles data, you can replace this with dynamic fetching from an API or state
    const articles = [
      {
        id: 1,
        title: "NEW DRONES USED IN WAR",
        description:
          "Some new drones have been spotted in the battlefield in Syria and Ukraine...",
        image: require("@/icons/drones.jpg"),
        content:
          "Drones: Revolutionizing Modern Warfare in Syria and Ukraine\n" +
          "Date: September 2024\n" +
          "Regions: Syria & Ukraine\n" +
          "\n" +
          "Drones have become a game-changer on the battlefield, particularly in conflict zones like Syria and Ukraine. What was once a futuristic tool is now an integral part of military operations, providing real-time intelligence, precision strikes, and vital reconnaissance for armed forces.\n" +
          "\n" +
          "Aerial Surveillance and Tactical Advantage\n" +
          "In Syria, drones are used by various factions to gather critical intelligence. They fly high above the battlefield, capturing live video feeds and helping military commanders make better-informed decisions. Whether it's spotting enemy movement or monitoring supply routes, drones offer a level of surveillance that was previously impossible without manned aircraft.\n" +
          "\n" +
          "In Ukraine, drones have become even more pivotal in the ongoing conflict with Russia. Ukrainian forces use drones to target Russian artillery positions, disrupt supply lines, and even deliver small, precise payloads. The ability to strike swiftly and silently from the sky gives Ukraine a tactical advantage in an otherwise chaotic and dangerous environment.\n" +
          "\n" +
          "Precision Strikes: Minimizing Collateral Damage\n" +
          "One of the most significant benefits of drones in modern warfare is their ability to conduct precision strikes. Unlike traditional airstrikes, which can result in significant collateral damage, drones can hit targets with pinpoint accuracy. This is particularly valuable in urban combat, where avoiding civilian casualties is a top priority.\n" +
          "\n" +
          "In both Syria and Ukraine, drones are being used to target specific military assets like tanks, artillery, and supply convoys, reducing the risk to nearby civilians and minimizing the destruction of critical infrastructure.\n" +
          "\n" +
          "The Role of Technology\n" +
          "The technology behind military drones is advancing at a rapid pace. Drones are now equipped with high-definition cameras, infrared sensors, and even AI-powered systems that can identify targets autonomously. These advancements make drones an even more formidable weapon, capable of operating in all types of weather and challenging environments.\n" +
          "\n" +
          "Both Syrian and Ukrainian forces rely heavily on drone technology to stay ahead of their enemies. The drones' ability to operate undetected, often at high altitudes, allows them to gather intelligence and execute strikes without risking human lives.\n" +
          "\n" +
          "The Future of Drones in Warfare\n" +
          "As drone technology continues to evolve, their role in military operations will only expand. With advancements in artificial intelligence, drones may soon be able to carry out even more complex tasks autonomously, further revolutionizing modern warfare.\n" +
          "\n" +
          "In Syria and Ukraine, drones have already proven their value in providing tactical advantages, but their future impact could be even greater. As more countries invest in drone technology, the landscape of global warfare will be forever changed.",
      },
      {
        id: 2,
        title: "ENTERTAINMENT BUZZ",
        description:
          "After some doubts Singer Taylor Swift is able to sing her soul out in the O2 Arena...",
        image: require("@/icons/music.jpg"),
        content:
          "Taylor Swift Shines in Sold-Out O2 Arena Show\n" +
          "Date: September 24, 2024\n" +
          "Venue: O2 Arena, London\n" +
          "\n" +
          "Taylor Swift lit up the O2 Arena in London with an unforgettable performance that left fans buzzing long after the final encore. As part of her latest tour, the pop icon wowed the packed crowd with a blend of old hits and new tracks, reaffirming why she’s one of the world’s most electrifying performers.\n" +
          "\n" +
          "A Night of Hits and Heartfelt Moments\n" +
          'From the opening notes of "Love Story" to the closing chords of "Anti-Hero," Taylor brought her signature energy and emotional depth to the stage. Fans screamed in excitement as she flawlessly transitioned between her biggest hits, including "Shake It Off," "You Belong With Me," and the crowd favorite, "Blank Space."\n' +
          "\n" +
          'Taylor’s voice soared through every song, effortlessly hitting every note. But what made the night truly special was her ability to connect with the audience. She took moments between songs to share stories about her songwriting and reflect on the journey that brought her to this stage. "This is a dream come true for me, and I couldn’t have done it without all of you," she said, prompting cheers from the crowd.\n' +
          "\n" +
          "Stage Design and Visuals:\n" +
          'The stage design was just as dazzling as Taylor herself. Bright, colorful lights lit up the arena, creating a vibrant atmosphere. Massive screens displayed stunning visuals, enhancing the emotional depth of songs like "All Too Well" and "Cardigan." The O2 Arena\'s acoustics and sound system made sure every note, every lyric, was crystal clear, amplifying the magic of the night.\n' +
          "\n" +
          "Fans' Reactions:\n" +
          "For the thousands of Swifties in the crowd, this concert was a once-in-a-lifetime experience. Fans sang along to every word, with many holding up homemade signs and glowing bracelets in a sea of pink and purple lights. The energy in the arena was electric, with every song drawing massive applause and even tears from some fans. It was clear that Taylor’s connection with her audience runs deeper than just her music.\n" +
          "\n" +
          "Taylor’s Magic:\n" +
          'What sets Taylor apart from other performers is her authenticity. She’s not just a pop star—she’s a storyteller who takes her fans on a personal journey with every performance. Whether it was a quiet, intimate moment on piano for "Invisible String" or a full-out dance party during "Delicate," Taylor showed why she’s a true icon of this generation.\n' +
          "\n" +
          "Final Thoughts:\n" +
          "Taylor Swift’s performance at the O2 Arena was a night to remember. Her incredible talent, heartfelt interactions with fans, and top-notch production made it an experience that no one will forget. With her energy and passion, Taylor Swift continues to prove she’s not just a pop star—she’s a global phenomenon.",
      },
      {
        id: 3,
        title: "BARCELONA VS BAYERN THRILLER",
        description:
          "Bayern got absolutely thrashed 4-1 against their UCL rivals which was a very poor performance by the Germans...",
        image: require("@/icons/football.jpg"),
        content:
          "Barcelona Thrashes Bayern Munich 4-0 in UCL Thriller\n" +
          "Date: September 25, 2024\n" +
          "Venue: Camp Nou, Barcelona\n" +
          "\n" +
          "In a stunning Champions League clash, Barcelona delivered a 4-0 drubbing to Bayern Munich, leaving the German giants in shock. Despite Bayern's strong squad, they were completely outclassed by Barcelona’s fast and aggressive play.\n" +
          "\n" +
          "First Half: Barcelona’s Dominance\n" +
          "From the kick-off, Barcelona took control with their high pressing game. After just 18 minutes, Ansu Fati intercepted a loose pass from Joshua Kimmich and slotted it home to give Barcelona a 1-0 lead. Ten minutes later, Robert Lewandowski doubled the lead after a perfect through-ball from Sergio Busquets. Bayern's defense, led by Matthijs de Ligt and Dayot Upamecano, looked disorganized and vulnerable.\n" +
          "\n" +
          "Bayern's Struggles: Defensive Chaos\n" +
          "Bayern’s usual midfield dominance was nowhere to be seen. Thomas Müller, Leroy Sané, and Kingsley Coman were isolated up front, with little service coming through from the midfield. Kimmich, normally a rock in midfield, made several mistakes, including a poor pass that led to Barcelona’s third goal.\n" +
          "\n" +
          "Second Half: Barcelona Seals the Win\n" +
          "Bayern made a change at halftime, but it didn’t help. In the 58th minute, Frenkie de Jong sent a perfect pass to Ansu Fati, whose cross found Lewandowski for his second goal. Then, in the 72nd minute, Lewandowski completed his hat-trick after another error by Bayern’s defense. Barcelona ran out comfortable 4-0 winners.\n" +
          "\n" +
          "Key Players:\n" +
          "Robert Lewandowski (Barcelona): A clinical hat-trick performance.\n" +
          "Ansu Fati (Barcelona): Great vision and playmaking, involved in two goals.\n" +
          "Manuel Neuer (Bayern): Made key saves, but couldn’t stop the onslaught.\n" +
          "Joshua Kimmich (Bayern): A poor game; several mistakes led to goals.\n" +
          "Analysis:\n" +
          "Barcelona’s pressing game was top-notch, suffocating Bayern and forcing mistakes. In contrast, Bayern looked sluggish and lacked cohesion in both defense and attack. It was a performance far below their usual standards, raising serious questions about their form in this year’s UCL.\n" +
          "\n" +
          "Post-Match Thoughts:\n" +
          "Xavi Hernandez (Barcelona Head Coach): “We were excellent today. Our press was on point, and the team showed quality in attack.”\n" +
          "Julian Nagelsmann (Bayern Head Coach): “We made too many mistakes, and Barcelona punished us. It’s a tough result to swallow.”\n" +
          "Conclusion:\n" +
          "\n" +
          "Barcelona’s dominant 4-0 victory over Bayern Munich is a huge statement in the UCL, while Bayern now face tough questions about their performance. Barcelona, on the other hand, will be full of confidence as they look to challenge for the title this season.",
      },
    ];

    // Find the article by id and set it in data
    this.article = articles.find((a) => a.id === parseInt(this.id));
  },
};
</script>

<style scoped>
.article-detail h1 {
  font-size: 2.5rem;
  margin-bottom: 20px;
}

.article-detail p {
  font-size: 1.1rem;
  line-height: 1.6;
}

.article-detail .article-content {
  margin-top: 20px;
  font-size: 1.1rem;
  line-height: 1.8;
  color: black;
  background-color: white;
}

.article-image {
  max-width: 100%; /* Ensure the image is responsive */
  height: auto;
  margin-top: 20px;
  border-radius: 10px;
}
</style>
